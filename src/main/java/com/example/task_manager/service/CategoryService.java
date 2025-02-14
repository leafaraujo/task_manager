package com.example.task_manager.service;

import com.example.task_manager.models.Category;
import com.example.task_manager.repositories.CategoryRepository;
import com.example.task_manager.util.Transacional;

import jakarta.inject.Inject;
import java.io.Serializable;

public class CategoryService implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;

    @Transacional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Transacional
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
