package com.az.service;

import com.az.entity.Customer;
import com.az.repository.CustomerRepository;
import org.springaicommunity.mcp.annotation.McpTool;
import lombok.RequiredArgsConstructor;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    @McpTool(name = "getAllCustomers", description = "Get all customers")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @McpTool(description = "save a new customer")
    public Customer createCustomer(@McpToolParam(description = "The Customer to save (name ) ") Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    @McpTool(description = "Find a customer by id")
    public Customer findCustomerById(@McpToolParam(description = "the Custtomer id") Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
