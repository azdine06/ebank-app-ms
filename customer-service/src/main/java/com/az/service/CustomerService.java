package com.az.service;

import com.az.entity.Customer;
import com.az.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public Customer findCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
