package com.example.inventorymanagementbackend.service;

import com.example.inventorymanagementbackend.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> findProductsByName(String name);
    List<Product> findProductsByCategory(Long categoryId);
    List<Product> findProductsBySupplier(Long supplierId, Integer minQuantity);
    List<Product> findProductsByStatus(String status);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product updateProductStock(Long id, Integer quantity);
}