package at.sinclothing.backend.pojos;

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
    @GeneratedValue
    private Long sizeId;

    @Basic(optional = false)
    @NonNull
    private String name;

    @ManyToMany
    @JoinTable(name = "product_size",
        joinColumns = {@JoinColumn(name = "size_id")},
        inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products = new ArrayList<>();
}
