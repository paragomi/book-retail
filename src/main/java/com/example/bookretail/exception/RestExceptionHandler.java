package com.example.bookretail.exception;

import org.springframework.core.*;
import org.springframework.core.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

//@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            NotEnoughStockException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(),ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
    @ExceptionHandler(NotEnoughStockException.class)
    protected ResponseEntity<Object> handleInsufficientStorage(
            NotEnoughStockException ex){
        ApiError apiError = new ApiError(HttpStatus.INSUFFICIENT_STORAGE,ex.getMessage(),ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
    @ExceptionHandler(CountMustGreaterThanZero.class)
    protected ResponseEntity<Object> handleInvalidQuantity(
            NotEnoughStockException ex){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex.getMessage(),ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
}
