package com.example.customer.customer.service;

import com.example.customer.customer.model.Account;
import com.example.customer.customer.model.Customer;
import com.example.customer.customer.model.UpdateCustomer;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomer();
    public void addCustomer(Customer customer);
    public Customer findById(Integer id);
   // public void type(AccType accType);
    public Customer updatecust(Integer id, UpdateCustomer updateCustomer);
    public String deleteCustomer(Integer id);

}
