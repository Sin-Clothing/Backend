package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonDeserialize(using = JsonDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-M-d, H:m:s")
    private LocalDateTime date;

//    @Enumerated(EnumType.STRING)
//    @NonNull
//    @Column(name = "payment_status")
//    private PaymentStatus paymentStatus;

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;

    @NonNull
    private double amount;

    @NonNull
    private String address;

//    @Enumerated(EnumType.STRING)
//    @NonNull
//    @Column(name = "payment_method")
//    private PaymentMethod paymentMethod;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    @JsonIgnore
//    private Customer customer;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item){
        if (!orderItems.contains(item)){
            orderItems.add(item);
            item.setOrderId(this);
        }
    }
}
