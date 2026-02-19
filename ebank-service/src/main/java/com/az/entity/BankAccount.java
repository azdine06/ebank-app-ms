package com.az.entity;

import com.az.model.Customer;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private String currency;
    private Long customerId;
    @Transient
    private Customer customer;
}
