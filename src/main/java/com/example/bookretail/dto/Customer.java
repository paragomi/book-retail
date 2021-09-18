package com.example.bookretail.dto;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "customers")
public class Customer  {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addOrder(Order order){
        if (orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
    }


}
