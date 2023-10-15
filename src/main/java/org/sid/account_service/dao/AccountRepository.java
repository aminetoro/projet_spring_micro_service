package org.sid.account_service.dao;

import org.sid.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface AccountRepository extends JpaRepository<BankAccount,String> {

}
