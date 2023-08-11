package com.ermeson.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ermeson.bookstore.model.Book;
import com.ermeson.bookstore.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok().body(book);        
    }



}
