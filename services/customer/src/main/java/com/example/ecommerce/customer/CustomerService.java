package com.example.ecommerce.customer;

import com.example.ecommerce.exception.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerMapper mapper;
    private CustomerRepository repository;
    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }
    public void updateCustomer(CustomerRequest request){
        var customer = repository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
                format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())
        ));
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(customer.getFirstname())){
            customer.setFirstname(request.firstname());
            if(StringUtils.isNotBlank(customer.getLastname())) {
                customer.setLastname(request.lastname());
                if (StringUtils.isNotBlank(customer.getEmail())) {
                    customer.setEmail(request.email());
                    if (request.adress() != null) {
                        customer.setAdress(request.adress());

                    }
                }

            }}}

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll().stream().map(mapper::fromCustomer).collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
    return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId).map(mapper::fromCustomer)
                .orElseThrow(() ->new CustomerNotFoundException(format("The ID provided does not refer to any customer ! ID:: %s", customerId)));

    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);}

}