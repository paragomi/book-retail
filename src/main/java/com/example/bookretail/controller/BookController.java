package com.example.bookretail.controller;

import com.example.bookretail.dto.*;
import com.example.bookretail.model.*;
import com.example.bookretail.service.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public Book addNewBook(@Valid @RequestBody BookCreateRequest request){
        return bookService.saveBook(mapper.map(request,Book.class));
    }

    @PatchMapping("/{bookId}/update-stock/{newQuantity}")
    public Book updateStock(@PathVariable String bookId,@PathVariable int newQuantity){
        return bookService.updateStock(bookId,newQuantity);
    }
}
