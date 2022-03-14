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

import java.net.URI;

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
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(order.getEmail());
            System.out.println(order.getEmail());
            mailMessage.setSubject("Order Confirmation");
            mailMessage.setFrom("kainbock.pos@gmail.com");
            String text = "Rechnung: "+order.getAmount();
            mailMessage.setText(text);
            emailSenderService.sendEmail(mailMessage);
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
