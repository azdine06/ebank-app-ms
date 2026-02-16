package com.az.web;

import com.az.entity.Customer;
import com.az.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return service.findCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(Long id) {
        service.deleteCustomer(id);
    }
}
