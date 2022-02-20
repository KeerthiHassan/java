package com.example.customer.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomer
{
    @NotBlank(message = "customer name should not be blank")
    private String firstName;
    private String lastName;
    @Size(min = 10, message = "contact no must be 10 digit")
    private Long contact;
    private String address;
    private String status;
}
