package abhishek.yummy.service;

import abhishek.yummy.Entity.Customer;
import abhishek.yummy.dto.CustomerRequest;
import abhishek.yummy.dto.CustomerResponse;
import abhishek.yummy.mapper.CustomerMapper;
import abhishek.yummy.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Customer created";
    }
}
