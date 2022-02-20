package com.example.account.account.service;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;
import com.example.account.account.model.AccountBalance;
import com.example.account.account.model.AccountType;
import com.example.account.account.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

@Service
public class AccountImpl implements AccountService
{
  @Autowired
  AccountRepo accountRepo;

  @Override
  public List<Account> getAllAccount()
  {
    return (List<Account>) accountRepo.findAll();
  }

  @Override
  public Account addAccount(Account account) {
    return accountRepo.save(account);
  }

  @Override
  public Account findById(Integer id) {
    return accountRepo.findByCustomerId(id);
  }


  @Override
  public Account findId(Integer id)
  {
    return accountRepo.findByAccountId(id);
  }

  //@Override
 /** public Account type(Integer id) throws AccountNotFoundException {
  Optional<Account> actype= Optional.ofNullable(accountRepo.findByAccountId(id));
  if(!actype.isPresent())
    throw new AccountNotFoundException("check for the Account Id");
  Account account1=actype.get();
  account1.setAccountType(account.getAccountType());
  Account a=accountRepo.save(account);
  return a;
  }**/

 @Override
  public String type(Integer id, AccountType accountType)
 {
     Account account1=accountRepo.findByAccountId(id);
     account1.setAccountType(accountType.getAccountType());
     accountRepo.save(account1);

     return "Account type is :" +account1.getAccountType();

 }

    @Override
    public String accBalance(Integer id, AccountBalance accountBalance)
    {
        Account account2=accountRepo.findByAccountId(id);
        account2.setBalance(account2.getBalance()+accountBalance.getBalance());
        accountRepo.save(account2);
        return "Balance is :" +account2.getBalance();
    }

    @Override
    public String deleteAccount(Integer id)
    {
        Account account = accountRepo.findByCustomerId(id);
        account.setStatus("InActive");
        accountRepo.save(account);
        return ""+account.getStatus();
        //account.setIsActive(false);
        // accountRepo.save(account);
        // return "this account is deleted";
    }

}



