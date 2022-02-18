package com.example.account.account.controller;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;
import com.example.account.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void addAccount(@RequestBody Integer customerId, AccType accType)
    {
        //Account add= accountService.addAccount(customerId);
        Account add=new Account();
        add.setCustomerId(customerId);
        add.setCreationDate(LocalDate.now());
        //add.setAccType(accType);//setting up the acctype through customer
        //return  new ResponseEntity<Account>(add, HttpStatus.OK);
        accountService.addAccount(add);
    }



    @GetMapping("/findid/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") Integer id)
    {
        Account find=accountService.findById(id);
        return new ResponseEntity<Account>(find, HttpStatus.OK);
    }

}
