package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NamedQueries({
    @NamedQuery(name = "ProductCategory.getAll", query = "SELECT c FROM product_category c")
})
public class ProductCategory implements Serializable {

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Basic(optional = false)
    @NonNull
    private String name;

    @NonNull
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (!products.contains(product)){
            products.add(product);
            product.setProductCategory(this);
        }
    }
}
