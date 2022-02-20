package com.example.customer.customer.service;

import com.example.customer.customer.feign.Feign;
import com.example.customer.customer.model.Account;
import com.example.customer.customer.model.Customer;
import com.example.customer.customer.model.UpdateCustomer;
import com.example.customer.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerImpl implements CustomerService
{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Feign feign;

    @Override
    public List<Customer> getCustomer() {
        return  customerRepo.findAll();
    }

    @Override
    public void addCustomer (Customer customer)
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        customerRepo.save(customer);
        Integer customerId = customer.getCustomerId();
        HttpEntity<Integer> httpEntity = new HttpEntity<>(customerId, header);
      //  HttpEntity<AccType> httpEntity1=new HttpEntity<>(accType, header);
       // Account account=new Account();

        //RestTemplate to communicate with Account application which is identified by using the URL
        restTemplate.postForObject("http://accounts/acc/addcustomer", httpEntity, void.class);


    }

    @Override
    public Customer findById(Integer id) {
        return customerRepo.findByCustomerId(id);
    }

    @Override
    public Customer updatecust(Integer id, UpdateCustomer updateCustomer)
    {
        Customer customer1=customerRepo.findByCustomerId(id);
        customer1.setFirstName(updateCustomer.getFirstName());
        customer1.setLastName(updateCustomer.getLastName());
        customer1.setContact(updateCustomer.getContact());
        customer1.setAddress(updateCustomer.getAddress());
        customer1.setStatus(updateCustomer.getStatus());
        return  customerRepo.save(customer1);

    }

    @Override
    public String deleteCustomer(Integer id)
    {
        Customer customer=customerRepo.findByCustomerId(id);
        customer.setStatus(feign.deleteAccount(id));
        customerRepo.save(customer);
        return "customer is deleted:"+id;
    }

    /** @Override
    public void type(AccType accType)
    {
        HttpHeaders ht=new HttpHeaders();
        ht.setContentType(MediaType.APPLICATION_JSON);
        Account a=new Account();
        AccType ac= a.getAccType();
        HttpEntity<AccType> httpEntity = new HttpEntity<>(accType, ht);
        restTemplate.postForObject("http://accounts/acc/addcustomer", httpEntity, void.class);
    }**/



}
