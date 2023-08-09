package com.ermeson.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ermeson.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
