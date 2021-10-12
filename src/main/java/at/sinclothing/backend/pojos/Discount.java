package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Discount implements Serializable {

    @Id
    @GeneratedValue
    private Long discountId;

    @Basic(optional = false)
    @NonNull
    private int percent;
    @Basic(optional = false)
    @NonNull
    private String name;
    @Basic(optional = false)
    @NonNull
    private boolean active;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (!products.contains(product)){
            products.add(product);
            product.setDiscount(this);
        }
    }
}
