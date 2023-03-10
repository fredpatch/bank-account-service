package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;

    //For the services
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    //Using get mapping to send a request
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    //To consult an account/List of account
    @GetMapping("/bankAccounts/{id}")
    //Using the annotation Path to specify that we're returning a path
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String
                        .format("Account %s Not Found !",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null)bankAccount.setId(UUID.randomUUID().toString());
        if (bankAccount.getCreation_date()==null)bankAccount.setCreation_date(new Date());

        return bankAccountRepository.save(bankAccount);
    }

    //Update existing account by id
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        //Retrieve first the account that need to be edited
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String
                        .format("Account %s not Found!!",id)));
        //update account with new entries
        if(bankAccount.getBalance()!=null){account.setBalance(bankAccount.getBalance());}
        if(bankAccount.getCurrency()!=null){account.setCurrency(bankAccount.getCurrency());}
        if(bankAccount.getType()!=null){account.setType(bankAccount.getType());}
        if(bankAccount.getCreation_date()!=null){account.setCreation_date(new Date());}
        return bankAccountRepository.save(account);
    }

    //Delete account
    @DeleteMapping("/bankAccounts/{id}")
    //Using the annotation Path to specify that we're returning a path
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
