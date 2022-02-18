package com.example.account.account.service;

import com.example.account.account.constants.AccType;
import com.example.account.account.model.Account;
import com.example.account.account.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



}

