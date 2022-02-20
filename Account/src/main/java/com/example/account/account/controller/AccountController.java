package com.example.account.account.controller;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;
import com.example.account.account.model.AccountBalance;
import com.example.account.account.model.AccountType;
import com.example.account.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/acc")
public class AccountController
{
    @Autowired
    AccountService accountService;

    @GetMapping("/accountinfo")
    public ResponseEntity<List<Account>> getAllAccount()
    {
        List<Account> account =accountService.getAllAccount();
        return new ResponseEntity<List<Account>>(account, HttpStatus.OK);

    }

    @PostMapping("/addcustomer")
    public void addAccount(@RequestBody Integer customerId)
    {
        //Account add= accountService.addAccount(customerId);
        Account add=new Account();
        add.setCustomerId(customerId);
        add.setCreationDate(LocalDate.now());
        //add.setAccType(accType);//setting up the acctype through customer
        //return  new ResponseEntity<Account>(add, HttpStatus.OK);
        accountService.addAccount(add);
    }



    @GetMapping("/findid/{id}")// finding account information only by account
    public ResponseEntity<Account> findById(@PathVariable("id") Integer id)
    {
        Account find=accountService.findById(id);
        return new ResponseEntity<Account>(find, HttpStatus.OK);
    }

    /**@PutMapping("/Acctype/{id}")
    public ResponseEntity<Account> type(@PathVariable("id") Integer accountId, Account account2) throws AccountNotFoundException {
       Account ac=accountService.type(accountId,account2);
        return new ResponseEntity<Account>(ac, HttpStatus.OK);

    }**/

    @PutMapping("/Acctype/{id}")
    public ResponseEntity<String> type(@PathVariable("id") Integer id,@RequestBody AccountType accountType) {

        return new ResponseEntity<>(accountService.type(id,accountType), HttpStatus.OK);
    }

    @PutMapping("/balance/{id}")
    public ResponseEntity<String> accBalance(@PathVariable("id") Integer id, @RequestBody AccountBalance accountBalance) {

        return new ResponseEntity<>(accountService.accBalance(id,accountBalance), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(accountService.deleteAccount(id),HttpStatus.OK);
    }


}
