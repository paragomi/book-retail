package com.example.bookretail.exception;

import lombok.*;
import org.springframework.http.*;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;
    private String error;



    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.error = error;
    }
}