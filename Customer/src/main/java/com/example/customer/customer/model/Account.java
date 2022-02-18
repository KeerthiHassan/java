package com.example.customer.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account
{
    @Id
    private int accountId;
    private int customerId;
    private LocalDate creationDate;
   // private AccType accType; //type of account

}
