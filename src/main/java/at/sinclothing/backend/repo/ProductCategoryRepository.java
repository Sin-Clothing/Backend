package at.sinclothing.backend.repo;

import at.sinclothing.backend.pojos.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}