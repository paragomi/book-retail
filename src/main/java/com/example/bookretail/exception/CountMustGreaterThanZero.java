package com.example.bookretail.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CountMustGreaterThanZero extends RuntimeException {
    public CountMustGreaterThanZero(String message){
        super(message);
    }
}
