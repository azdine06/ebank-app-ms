package com.az.entity;

import com.az.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue
    private String id;
    private Date createdAt;
    private Double balance;
    private String Type;
    private Long customerId;
    @Transient
    private Customer customer;
}
