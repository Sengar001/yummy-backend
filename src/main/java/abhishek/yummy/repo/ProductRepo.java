package abhishek.yummy.repo;

import abhishek.yummy.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
