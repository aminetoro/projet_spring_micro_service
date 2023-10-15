package org.sid.account_service.services;

import org.sid.account_service.dto.BankAccountRequestDTO;
import org.sid.account_service.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

}
