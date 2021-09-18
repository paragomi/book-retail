package com.example.bookretail.service;

import com.example.bookretail.dto.*;
import com.example.bookretail.exception.*;
import com.example.bookretail.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }


    public Book findById(String bookId){
        Book bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity == null) {
            throw new NotFoundException("Book not found :"+bookId);
        }
        return bookEntity;
    }


    @Transactional
    public Book updateStock(String bookId,int newQuantity){
        Book foundedBook = bookRepository.findByBookId(bookId);
        if (foundedBook == null){
            throw new NotFoundException("Book not found:"+bookId);
        }
        foundedBook.setStock(newQuantity);
        return bookRepository.save(foundedBook);
    }

}
