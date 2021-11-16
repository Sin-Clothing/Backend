package at.sinclothing.backend.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryPK implements Serializable {
    private LocalDate createdAt;
    private Long product;
}
