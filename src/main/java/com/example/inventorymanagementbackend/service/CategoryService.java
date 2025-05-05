package com.example.inventorymanagementbackend.service;

import com.example.inventorymanagementbackend.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    List<Category> findCategoriesByName(String name);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
    Category updateCategory(Long id, Category categoryDetails);
}