package com.example.account.account.service;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;
import com.example.account.account.model.AccountBalance;
import com.example.account.account.model.AccountType;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService
{
    public List<Account> getAllAccount();
    public Account addAccount(Account account);
    public Account findById(Integer id);
    //public AccType type(AccType accType);
    public Account findId(Integer id);
  public String type(Integer id, AccountType accountType);
  public String accBalance(Integer id, AccountBalance accountBalance);
  public String deleteAccount(Integer id);
  //public Boolean active(Integer id);


}
