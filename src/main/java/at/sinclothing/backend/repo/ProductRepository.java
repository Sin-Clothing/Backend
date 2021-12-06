package at.sinclothing.backend.repo;

import at.sinclothing.backend.pojos.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}