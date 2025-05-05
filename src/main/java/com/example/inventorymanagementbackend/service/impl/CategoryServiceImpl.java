package com.example.inventorymanagementbackend.service.impl;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.Category;
import com.example.inventorymanagementbackend.repository.CategoryRepository;
import com.example.inventorymanagementbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findCategoriesByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Category saveCategory(Category category) {
        if (category.getCategoryId() == null) {
            category.setCreatedAt(LocalDateTime.now());
        }
        category.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDetails.getName());
                    category.setDescription(categoryDetails.getDescription());
                    category.setUpdatedAt(LocalDateTime.now());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }
}