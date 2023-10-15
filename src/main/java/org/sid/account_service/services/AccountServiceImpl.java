package org.sid.account_service.services;

import org.sid.account_service.dao.AccountRepository;
import org.sid.account_service.dto.BankAccountRequestDTO;
import org.sid.account_service.dto.BankAccountResponseDTO;
import org.sid.account_service.entities.BankAccount;
import org.sid.account_service.mappers.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    final AccountRepository accountRepository;
    final AccountMapper accountMapper;


    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder().
                id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = accountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(saveBankAccount);
    }
}
