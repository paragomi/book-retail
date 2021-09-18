package com.example.bookretail.repository;

import com.example.bookretail.dto.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByCustomerId(String customerId);
    Customer findByEmail(String email);
}
