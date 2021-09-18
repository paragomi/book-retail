package com.example.bookretail.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.math.*;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsResponse {
    private int _id;
    private String month;
    private int orderCount;

    private BigDecimal totalPurchasedAmount;
    private int bookCount;
}
