package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PaymentStatus implements Serializable {

    @Id
    private int statusId;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "paymentStatus", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
            order.setPaymentStatus(this);
        }
    }

}
