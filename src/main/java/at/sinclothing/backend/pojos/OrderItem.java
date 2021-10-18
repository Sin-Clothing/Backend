package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NonNull
    private int quantity;

}
