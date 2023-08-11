package com.ermeson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermeson.bookstore.exceptions.ObjectNotFoundException;
import com.ermeson.bookstore.model.Book;
import com.ermeson.bookstore.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFoundException(
            "Livro não encontrado! Id: " + id + ", tipo: " + Book.class.getName()
        ));
    }

    public List<Book> findAll(Integer id_cat) {
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

}
