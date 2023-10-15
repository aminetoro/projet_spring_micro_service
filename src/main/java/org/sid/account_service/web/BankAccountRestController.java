package org.sid.account_service.web;


import org.sid.account_service.dao.AccountRepository;
import org.sid.account_service.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class BankAccountRestController {

    private AccountRepository accountRepository;

    public BankAccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return accountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        return accountRepository.findById(id).get();
    }
    @PostMapping("/bankAccounts")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return accountRepository.save(bankAccount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        accountRepository.deleteById(id);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        bankAccount.setId(id);
        return accountRepository.save(bankAccount);
    }
}
