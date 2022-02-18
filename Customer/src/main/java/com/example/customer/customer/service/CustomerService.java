package com.example.customer.customer.service;

import com.example.customer.customer.model.AccType;
import com.example.customer.customer.model.Customer;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomer();
    public void addCustomer(Customer customer);
    public Customer findById(Integer id);
   // public void type(AccType accType);
}
