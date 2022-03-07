package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(OrderItemPK.class)
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product productId;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @JsonProperty("qty")
    private int quantity;

}
