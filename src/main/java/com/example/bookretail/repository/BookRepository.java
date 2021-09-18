package com.example.bookretail.repository;

import com.example.bookretail.dto.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
    Book findByBookId(String bookId);
}
