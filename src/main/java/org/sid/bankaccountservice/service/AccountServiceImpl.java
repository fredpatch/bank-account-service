package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mapper.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper mapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =  BankAccount.builder()
                .creation_date(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .id(UUID.randomUUID().toString())
                .build();

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO responseDTO = mapper.fromBankAccount(saveBankAccount);

        return responseDTO;
    }
}
