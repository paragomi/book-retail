package com.example.bookretail.dto;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.*;
import java.math.*;
import java.time.*;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "orders")
public class Order implements Serializable {
    @Id
    private String orderId;

    private String customerId;

    private Book book;
    private int bookCount;
    private LocalDate orderDate ;

    @Field(targetType = DECIMAL128)
    private BigDecimal totalAmount;
    private int month;

    public Order(String customerId, Book book, int bookCount) {
        this.customerId = customerId;
        this.book = book;
        this.bookCount = bookCount;
    }
}
