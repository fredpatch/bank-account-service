package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.Account_Type;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

    private String id;
    private Date creation_date;
    private Double balance;
    private String currency;
    private Account_Type type;
}
