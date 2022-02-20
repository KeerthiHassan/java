package com.example.account.account.model;

import com.example.account.account.constants.AccType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accountinfo")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    private int customerId;
    private LocalDate creationDate;
   //@Enumerated(EnumType.STRING)
  // private AccType accType;
    private String accountType;
    private int balance;
    private String status;


}
