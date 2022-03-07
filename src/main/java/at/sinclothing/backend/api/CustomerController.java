package at.sinclothing.backend.api;

import at.sinclothing.backend.pojos.Customer;
import at.sinclothing.backend.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("checkout")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try{
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(customer.getCustomerId())
                    .toUri();
            return  ResponseEntity.created(location).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
