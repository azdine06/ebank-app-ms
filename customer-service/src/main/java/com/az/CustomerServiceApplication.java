package com.az;

import com.az.entity.Customer;
import com.az.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService service) {
        return args -> {
            List<String> names = List.of("Aziz", "Hasan", "Mohammad");
            names.forEach(name -> {
                service.createCustomer(Customer.builder()
                        .name(name)
                        .email(name + "@gmail.com")
                        .build());
            });
        };
    }
}
