package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "product_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@IdClass(ProductInventoryPK.class)
public class ProductInventory implements Serializable {

    @NonNull
    @Basic(optional = false)
    private int quantity;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "size_id")
    private Size size;
}
