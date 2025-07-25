package com.saintroche.categories.service;

import java.util.List;
import java.util.Optional;

import com.saintroche.categories.models.entities.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
