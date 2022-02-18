package com.example.account.account.service;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;

import java.util.List;

public interface AccountService
{
    public List<Account> getAllAccount();
    public Account addAccount(Account account);
    public Account findById(Integer id);
    //public AccType type(AccType accType);


}
