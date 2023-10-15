package org.sid.account_service.dao;

import org.sid.account_service.entities.AccountType;
import org.sid.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface AccountRepository extends JpaRepository<BankAccount,String> {
   @RestResource(path = "/byCr")
   List<BankAccount> findByCurrency(@Param("t") String currency);
   List<BankAccount> findByType(AccountType type);
}
