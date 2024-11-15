package abhishek.yummy.service;

import abhishek.yummy.Entity.Customer;
import abhishek.yummy.dto.CustomerRequest;
import abhishek.yummy.dto.CustomerResponse;
import abhishek.yummy.exception.CustomerNotFound;
import abhishek.yummy.mapper.CustomerMapper;
import abhishek.yummy.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Customer created";
    }

    public Customer getCustomer(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new CustomerNotFound(
                   format("No customer found by the given ID : %s", id)
                ));
    }

    public CustomerResponse retrieveCustomer(Long id) {
        Customer customer = getCustomer(id);
        return mapper.toCustomerResponse(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        return repo.findAll().stream()
                .map(customerMapper::toCustomerResponse) // map Customer to CustomerResponse
                .collect(Collectors.toList());
    }

}
