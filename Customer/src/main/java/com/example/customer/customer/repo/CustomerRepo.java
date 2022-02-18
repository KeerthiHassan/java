package com.example.customer.customer.repo;

import com.example.customer.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepo extends MongoRepository<Customer, String> {
    Customer findByCustomerId(Integer id);
}
