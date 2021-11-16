package at.sinclothing.backend.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue
    private Long categoryId;

    @Basic(optional = false)
    @NonNull
    private String name;
    @NonNull
    private String description;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (!products.contains(product)){
            products.add(product);
            product.setProductCategory(this);
        }
    }
}
