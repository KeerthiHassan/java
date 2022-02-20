package com.example.account.account.model;

import com.example.account.account.constants.AccType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountType
{
  //  @Enumerated(EnumType.STRING)
  //  private AccType accType;
    private String accountType;
}