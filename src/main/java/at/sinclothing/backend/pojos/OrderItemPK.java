package at.sinclothing.backend.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPK implements Serializable {
    private Long productId;
    private Long orderId;
}
