package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    @NonNull
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @NonNull
    private double amount;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item){
        if (!orderItems.contains(item)){
            orderItems.add(item);
            item.setOrderId(this);
        }
    }
}
