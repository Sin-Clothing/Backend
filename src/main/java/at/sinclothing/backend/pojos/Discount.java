package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "discount")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Discount implements Serializable {

    @Id
    @Column(name = "discount_id")
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
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (!products.contains(product)){
            products.add(product);
            product.setDiscount(this);
        }
    }
}
