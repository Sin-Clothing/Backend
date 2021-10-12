package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PaymentMethod implements Serializable {

    @Id
    @GeneratedValue
    private Long methodId;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        if (!orders.contains(order)){
            orders.add(order);
            order.setPaymentMethod(this);
        }
    }

}
