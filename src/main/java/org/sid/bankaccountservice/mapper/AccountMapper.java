package org.sid.bankaccountservice.mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
            BankAccountResponseDTO responseDTO= new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, responseDTO );

        return responseDTO;

    }
}
