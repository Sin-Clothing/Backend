package at.sinclothing.backend.repo;

import at.sinclothing.backend.pojos.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}