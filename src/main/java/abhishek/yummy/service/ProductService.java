package abhishek.yummy.service;

import abhishek.yummy.Entity.Product;
import abhishek.yummy.dto.ProductRequest;
import abhishek.yummy.mapper.ProductMapper;
import abhishek.yummy.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper mapper;
    private final ProductRepo repo;


    public String createProduct(ProductRequest request) {
        Product product = mapper.toEntity(request);
        repo.save(product);
        return "Product Added Successfully";
    }
}
