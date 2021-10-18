package at.sinclothing.backend.pojos;

import com.sun.istack.NotNull;
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
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Basic(optional = false)
    @NonNull
    private String name;
    private Double price;
    private String pictureUrl;

    @ManyToMany(mappedBy = "products")
    private List<Size> sizes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ProductInventory> productInventoryHistory = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        if(!orderItems.contains(orderItem)){
            orderItems.add(orderItem);
            orderItem.setProduct(this);
        }
    }

    public void addProductInventory(ProductInventory productInventory){
        if(!productInventoryHistory.contains(productInventory)){
            productInventoryHistory.add(productInventory);
            productInventory.setProduct(this);
        }
    }
}
