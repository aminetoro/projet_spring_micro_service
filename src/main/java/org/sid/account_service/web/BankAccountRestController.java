package org.sid.account_service.web;


import org.sid.account_service.dao.AccountRepository;
import org.sid.account_service.dto.BankAccountRequestDTO;
import org.sid.account_service.dto.BankAccountResponseDTO;
import org.sid.account_service.entities.BankAccount;
import org.sid.account_service.mappers.AccountMapper;
import org.sid.account_service.services.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountRestController {

    private AccountRepository accountRepository;
    private AccountServiceImpl accountService;
    private AccountMapper accountMapper;

    public BankAccountRestController(AccountRepository accountRepository, AccountServiceImpl accountService, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
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
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
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
