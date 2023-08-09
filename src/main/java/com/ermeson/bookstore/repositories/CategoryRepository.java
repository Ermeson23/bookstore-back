package com.ermeson.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ermeson.bookstore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
