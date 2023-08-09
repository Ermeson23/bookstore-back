package com.ermeson.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermeson.bookstore.model.Book;
import com.ermeson.bookstore.model.Category;
import com.ermeson.bookstore.repositories.BookRepository;
import com.ermeson.bookstore.repositories.CategoryRepository;

@Service
public class DBService {

    @Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

    public void instanceDataBase() {
        
        Category cat1 = new Category(null, "Informática", "Livros de Informática");
        Category cat2 = new Category(null, "Matemática", "Livros de Matemática");
        Category cat3 = new Category(null, "Biografias", "Livros Bibliográficos");

		Book book1 = new Book(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
        Book book2 = new Book(null, "Design Patterns", "Gang of Four", "Lorem ipsum2", cat1);
		Book book3 = new Book(null, "Numbers Theory", "George E. Andrews", "Lorem ipsum3", cat2);
        Book book4 = new Book(null, "Introduction to Probability", "Joseph K. Blitzstein e Jessica Hwang", "Lorem ipsum4", cat2);
		Book book5 = new Book(null, "Artificial Intelligence", "Stuart Russell e Peter Norvig", "Lorem ipsum5", cat1);

		cat1.getBooks().addAll(Arrays.asList(book1, book2));
        cat2.getBooks().addAll(Arrays.asList(book3, book4, book5));

		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5));
    }
    
}
