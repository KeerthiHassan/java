package com.example.account.account.repo;

import com.example.account.account.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.net.Inet4Address;
import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Integer>
{
   Account findByCustomerId(Integer id);
   Account findByAccountId(Integer id);
}
