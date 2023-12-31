package com.ermeson.bookstore.dto;

import java.io.Serializable;

import com.ermeson.bookstore.model.Book;

public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDTO() {
        super();
    }
    public BookDTO(Book book) {
        super();
        this.id = book.getId();
        this.title = book.getTitle();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    
    
}
