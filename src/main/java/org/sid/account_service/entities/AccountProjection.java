package org.sid.account_service.entities;

import org.sid.account_service.dao.AccountRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
   public String getId();
   public AccountType getType();
}
