package com.ermeson.bookstore.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.ermeson.bookstore.model.Category;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;

    @NotEmpty(message = "O campo NOME é obrigatório")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 a 100 caracteres")
    private String name;

    @NotEmpty(message = "O campo DESCRIÇÃO é obrigatório")
    @Length(min = 5, max = 200, message = "O campo DESCRIÇÃO deve ter entre 5 a 200 caracteres")
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
