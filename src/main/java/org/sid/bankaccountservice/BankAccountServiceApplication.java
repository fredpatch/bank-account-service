package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.enums.Account_Type;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){

		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()

						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5? Account_Type.CURRENT_ACCOUNT:Account_Type.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000)
						.currency("MAD")
						.creation_date(new Date())
						.build();
				bankAccountRepository.save(bankAccount);

			}
		};
	}

}
