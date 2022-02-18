package com.example.customer.customer.controller;

import com.example.customer.customer.CustomerApplication;
import com.example.customer.customer.feign.Feign;
import com.example.customer.customer.model.AccType;
import com.example.customer.customer.model.Account;
import com.example.customer.customer.model.Customer;
import com.example.customer.customer.model.CustomerResponse;
import com.example.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
      private CustomerService customerService;

    @Autowired
    Feign feign;


    @GetMapping("/customedetails")
    public ResponseEntity<List<Customer>> getCustomer()
    {
        List<Customer> list= customerService.getCustomer();
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") Integer id)
    {

        Customer find= customerService.findById(id);
        Account account=feign.findById(id);
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setCustomer(find);
        customerResponse.setAccount(account);
        return new ResponseEntity<CustomerResponse>(customerResponse,HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addCustomer(@Valid @RequestBody Customer customer)
    {
      //Customer customer1=customerService.addCustomer(customer);
        customerService.addCustomer(customer);
      //return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);

    }

    /** @PostMapping("/addacctype")
    public void addCustomer(@RequestBody  AccType accType)
    {
        customerService.type(accType);

    }**/
}
