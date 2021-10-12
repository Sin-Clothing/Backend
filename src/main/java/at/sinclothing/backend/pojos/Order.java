package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long orderId;

    @NonNull
    private LocalDate date;
    @NonNull
    private double amount;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item){
        if (!orderItems.contains(item)){
            orderItems.add(item);
            item.setOrder(this);
        }
    }
}