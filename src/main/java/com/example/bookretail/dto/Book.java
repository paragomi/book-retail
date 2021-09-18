package com.example.bookretail.dto;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private String bookId;
    private BigDecimal price;
    private String bookName;
    private int stock;

    public void decrementStock(int minus){
        stock-=minus;
    }
}
