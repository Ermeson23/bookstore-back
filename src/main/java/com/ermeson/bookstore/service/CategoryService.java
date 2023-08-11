package com.ermeson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermeson.bookstore.exceptions.ObjectNotFoundException;
import com.ermeson.bookstore.model.Category;
import com.ermeson.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Registro não encontrado! Id: " + ", Tipo: " + Category.class.getName()));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    
}
