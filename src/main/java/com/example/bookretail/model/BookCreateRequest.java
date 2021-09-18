package com.example.bookretail.model;

import lombok.*;

import javax.validation.constraints.*;
import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {
    @Min(1)
    private BigDecimal price;
    @NotBlank(message = "Book name is mandatory")
    @NotNull(message = "Book name cannot be empty")
    private String bookName;
    @Min(1)
    private int stock;
}
