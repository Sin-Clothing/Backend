package at.sinclothing.backend.repo;

import at.sinclothing.backend.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}