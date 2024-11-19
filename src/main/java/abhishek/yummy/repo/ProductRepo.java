package abhishek.yummy.repo;

import abhishek.yummy.Entity.Customer;
import abhishek.yummy.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);
}
