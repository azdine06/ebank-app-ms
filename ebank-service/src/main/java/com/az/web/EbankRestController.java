package com.az.web;

import com.az.entity.BankAccount;
import com.az.service.EbankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/accounts")
@RequiredArgsConstructor
public class EbankRestController {

    private final EbankService service;

    @PostMapping
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        return service.saveBankAccount(bankAccount);
    }

    @GetMapping
    public List<BankAccount> getAllBankAccounts() {
        return service.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return service.getBankaccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        service.deleteBankAccount(id);
    }
}
