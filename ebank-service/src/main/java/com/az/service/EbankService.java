package com.az.service;

import com.az.entity.BankAccount;
import com.az.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbankService {

    private final BankAccountRepository repository;


    public EbankService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return repository.findAll();

    }

    public BankAccount getBankaccountById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Bank account not found"));

    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }
}

