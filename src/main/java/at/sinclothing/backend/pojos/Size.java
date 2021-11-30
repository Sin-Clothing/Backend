package at.sinclothing.backend.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "size")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Size implements Serializable {

    @Id
    @Column(name = "size_id")
    private Long sizeId;

    @Basic(optional = false)
    @NonNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "size", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ProductInventory> productInventories = new ArrayList<>();

    public void addProductInventory(ProductInventory productInventory){
        if(!productInventories.contains(productInventory)){
            productInventories.add(productInventory);
            productInventory.setSize(this);
        }
    }
}
