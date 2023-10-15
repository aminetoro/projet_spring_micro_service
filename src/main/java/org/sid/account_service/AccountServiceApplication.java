package org.sid.account_service;

import org.sid.account_service.dao.AccountRepository;
import org.sid.account_service.entities.AccountType;
import org.sid.account_service.entities.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(AccountServiceApplication.class, args);

    }

    @Bean
    public CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
//            BankAccount bankAccount = new BankAccount();
//            bankAccount.setId(UUID.randomUUID().toString());
//            bankAccount.setBalance(133.43);
//            bankAccount.setType(AccountType.CURRENT_ACCOUNT);
//            bankAccount.setBalance(6500);
//            bankAccount.setCreatedAt(new Date());

//            BankAccount bankAccount = new BankAccount(UUID.randomUUID().toString(), new Date(), 6500, AccountType.CURRENT_ACCOUNT);
            for(int i=0;i<10;i++){
                BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString()).createdAt(new Date()).type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT).balance(6500).build();
                accountRepository.save(bankAccount);
            }

        };
    }

}
