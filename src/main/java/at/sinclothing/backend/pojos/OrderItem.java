package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@IdClass(OrderItemPK.class)
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product productId;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order orderId;

    @NonNull
    private int quantity;

}
