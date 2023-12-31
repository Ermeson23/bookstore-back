package com.ermeson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermeson.bookstore.exceptions.ObjectNotFoundException;
import com.ermeson.bookstore.model.Book;
import com.ermeson.bookstore.model.Category;
import com.ermeson.bookstore.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book create(Integer id_cat, Book book) {
        book.setId(null);
        Category cat = categoryService.findById(id_cat);
        book.setCategory(cat);
        return bookRepository.save(book);
    }

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

    public Book update(Integer id, Book book) {
        Book newBook = findById(id);
        updateData(newBook, book);
        return bookRepository.save(newBook);
    }

    private void updateData(Book newBook, Book book) {
        newBook.setTitle(book.getTitle());
        newBook.setAuthorName(book.getAuthorName());
        newBook.setText(book.getText());
    }

    public void delete(Integer id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }

}
