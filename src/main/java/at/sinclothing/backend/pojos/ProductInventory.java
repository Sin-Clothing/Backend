package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductInventory implements Serializable {

    @Id
    @NonNull
    private LocalDate createdAt;

    @NonNull
    @Basic(optional = false)
    private int quantity;

    @ManyToOne
    private Product product;
}
