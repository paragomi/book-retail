package com.example.bookretail.model;

import lombok.*;

import java.time.*;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private String customerFirstName;
    private String customerLastName;
    private String bookName;
    private int quantity;
    private LocalDate orderDate;

    public OrderResponse(String customerFirstName, String customerLastName, String bookName, int quantity, LocalDate orderDate) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.bookName = bookName;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
}
