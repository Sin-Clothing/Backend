package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Product product;

    @Id
    @ManyToOne
    private Order order;

    @NonNull
    private int quantity;

}
