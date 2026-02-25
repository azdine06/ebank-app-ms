package com.az.service;

import com.az.entity.BankAccount;
import com.az.feign.CustomerRestClient;
import com.az.model.Customer;
import com.az.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {

    private final BankAccountRepository repository;
    private CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return repository.findAll();

    }

    public BankAccount getBankaccountById(String id) {
        BankAccount bankAccount = repository.findById(id).orElseThrow(() -> new RuntimeException("Bank account not found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(LocalDate.now());
            return repository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteBankAccount(String id) {
        repository.deleteById(id);
    }
}
