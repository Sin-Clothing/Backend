package at.sinclothing.backend.api;

import at.sinclothing.backend.mail.EmailSenderService;
import at.sinclothing.backend.pojos.Order;
import at.sinclothing.backend.pojos.OrderItem;
import at.sinclothing.backend.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("checkout")
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT})
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        try{
            for (OrderItem orderItem : order.getOrderItems()){
                orderItem.setOrderId(order);
            }
            orderRepository.saveAndFlush(order);

            LocalDateTime date = order.getDate();

            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("items", order.getOrderItems());
            templateModel.put("firstname", order.getFirstname());
            templateModel.put("lastname", order.getLastname());
            templateModel.put("amountExcl",
                    String.format("%.2f", new BigDecimal(order.getAmount()*0.8).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            templateModel.put("ust",
                    String.format("%.2f", new BigDecimal(order.getAmount()*0.2).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            templateModel.put("total",
                    String.format("%.2f", new BigDecimal(order.getAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            templateModel.put("date", String.format("%2d.%2d.%4d", date.getDayOfMonth(), date.getMonth().getValue(), date.getYear()));

            String[] tokens = order.getAddress().split(";");
            templateModel.put("country", tokens[0]);
            templateModel.put("city", tokens[1]);
            templateModel.put("streetname", tokens[2]);
            templateModel.put("streetnumber", tokens[3]);
            templateModel.put("doornumber", tokens[4]);
            templateModel.put("postalcode", tokens[5]);

            String rechnungsNr = "R-" + date.getYear()
                    + "-" + date.getMonth().getValue()
                    + "-" + date.getDayOfMonth()
                    + "-" + order.getOrderId();
            templateModel.put("rechnungsNr", rechnungsNr);

            String bestellNr = "#SIN" + order.getOrderId();
            templateModel.put("bestellNr", bestellNr);

            emailSenderService.sendMessageUsingThymeleafTemplate(order.getEmail(), "Sin-Clothing Rechnung", templateModel);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(order.getOrderId())
                    .toUri();
            return  ResponseEntity.created(location).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
