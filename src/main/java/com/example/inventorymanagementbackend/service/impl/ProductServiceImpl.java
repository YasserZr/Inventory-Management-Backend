package com.example.inventorymanagementbackend.service.impl;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.Product;
import com.example.inventorymanagementbackend.repository.ProductRepository;
import com.example.inventorymanagementbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    
    @Override
    public List<Product> findProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }
    
    @Override
    public List<Product> findProductsBySupplier(Long supplierId, Integer minQuantity) {
        return productRepository.findBySupplierIdAndStockQuantityGreaterThan(supplierId, minQuantity);
    }
    
    @Override
    public List<Product> findProductsByStatus(String status) {
        return productRepository.findByStatus(status);
    }
    
    @Override
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }
    
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    @Override
    public Product updateProductStock(Long id, Integer quantity) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setStockQuantity(quantity);
                    product.setUpdatedAt(LocalDateTime.now());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }
}