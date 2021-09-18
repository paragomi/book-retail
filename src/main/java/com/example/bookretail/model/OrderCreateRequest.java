package com.example.bookretail.model;

import lombok.*;

@Getter
public class OrderCreateRequest {
    private String customerId;
    private String bookId;
    private int bookCount;

    public OrderCreateRequest(String customerId, String bookId, int bookCount) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.bookCount = bookCount;
    }
}
