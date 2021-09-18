package com.example.bookretail.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(String message){
        super(message);
    }
}
