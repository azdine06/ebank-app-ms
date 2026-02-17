package com.az.web;

import com.az.entity.Customer;
import com.az.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return service.findCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(Long id) {
        service.deleteCustomer(id);
    }
}
