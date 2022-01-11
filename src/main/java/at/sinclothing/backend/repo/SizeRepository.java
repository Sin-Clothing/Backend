package at.sinclothing.backend.repo;

import at.sinclothing.backend.pojos.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Long> {

    @Query("SELECT s FROM size s INNER JOIN product_inventory i ON s.sizeId = i.size.sizeId WHERE i.product.productId = :product_id")
    List<Size> findSizeByProductID(@Param("product_id") Long id);
}