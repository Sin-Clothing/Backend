package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long customerId;

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String telephone;
    @NonNull
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address){
        if (!addresses.contains(address)){
            addresses.add(address);
            address.setCustomer(this);
        }
    }

    public void addOrder(Order order){
        if (!orders.contains(order)){
            orders.add(order);
            order.setCustomer(this);
        }
    }

}
