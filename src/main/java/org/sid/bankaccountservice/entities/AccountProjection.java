package org.sid.bankaccountservice.entities;

import org.sid.bankaccountservice.enums.Account_Type;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
   public String getId();
   public Account_Type getType();
   public Double getBalance();
}
