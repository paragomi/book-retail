package com.example.bookretail.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
    private String bookName;
    private int quantity;
}
