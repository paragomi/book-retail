package com.example.bookretail.service;

import com.example.bookretail.dto.*;
import com.example.bookretail.exception.*;
import com.example.bookretail.model.*;
import com.example.bookretail.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }



    public Customer findByCustomerId(String customerId){
        Customer foundedCustomer = customerRepository.findByCustomerId(customerId);
        if (foundedCustomer == null) {
            throw new NotFoundException("Customer not found :"+customerId);
        }
        return foundedCustomer;
    }

    public Customer createCustomer(Customer customer){
        validateCustomer(customer);
        return saveCustomer(customer);
    }

    private void validateCustomer(Customer customer){
        Customer foundedCustomer = customerRepository.findByEmail(customer.getEmail());
        if (foundedCustomer !=null){
            throw new CustomerAlreadyExists("Customer already exists with email:"+customer.getEmail());
        }
    }

    public List<OrderListResponse> getOrders(String customerId, Pageable pagable){
        return orderService.getCustomerOrders(customerId,pagable);
    }

    public List<StatisticsResponse> getMonthlyStatistics(String customerId){
        return orderService.getMonthlyStatistics(customerId);
    }
}
