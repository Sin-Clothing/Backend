package at.sinclothing.backend.pojos;

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

    @Id
    @NonNull
    private LocalDate createdAt;

    @NonNull
    @Basic(optional = false)
    private int quantity;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
