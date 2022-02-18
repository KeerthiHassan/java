package com.example.customer.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="customerinfo")
public class Customer
{
    @Id
    private String id;
    private int customerId;
    @NotBlank(message = "customer name should not be blank")
    private String customerName;
    @Min(value = 10, message = "contact no must be 10 digit")
    private Long contact;
    private String address;
    private AccType accType; // acctype from account


}
