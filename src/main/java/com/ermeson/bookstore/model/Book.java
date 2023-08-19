package com.ermeson.bookstore.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "O campo TÍTULO é obrigatório")
    @Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 a 50 caracteres")
    private String title;

    @NotEmpty(message = "O campo NOME_DO_AUTOR é obrigatório")
    @Length(min = 3, max = 50, message = "O campo NOME_DO_AUTOR deve ter entre 3 a 50 caracteres")
    private String authorName;

    @NotEmpty(message = "O campo TEXTO é obrigatório")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 a 2.000.000 caracteres")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(Integer id, String title, String authorName, String text, Category category) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.text = text;
        this.category = category;
    }

    public Book() {
        
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
