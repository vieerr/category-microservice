package com.saintroche.categories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saintroche.categories.models.entities.Category;
import com.saintroche.categories.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist"));

        if (category.getNombre() != null) {
            existingCategory.setNombre(category.getNombre());
        }
        if (category.getDescripcion() != null) {
            existingCategory.setDescripcion(category.getDescripcion());
        }

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if(!categoryRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Category with id " + id + " does not exist");
        }

        categoryRepository.deleteById(id);
    }
}
