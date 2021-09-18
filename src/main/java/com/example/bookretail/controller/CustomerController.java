package com.example.bookretail.controller;

import com.example.bookretail.dto.*;
import com.example.bookretail.model.*;
import com.example.bookretail.service.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Customer addNewCustomer(@Valid @RequestBody CustomerCreateRequest request){
        return customerService.createCustomer(modelMapper.map(request,Customer.class));
    }


    @GetMapping("/{customerId}/orders")
    public List<OrderListResponse> getCustomerOrders(@PathVariable String customerId, @RequestParam int page){
        Pageable pageable = PageRequest.of(page, 10);
        return customerService.getOrders(customerId,pageable);
    }

    @GetMapping("/{customerId}/monthly-statistics")
    public List<StatisticsResponse> getMonthlyStatistics(@PathVariable String customerId){
        return customerService.getMonthlyStatistics(customerId);
    }
}
