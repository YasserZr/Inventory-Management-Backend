package com.example.inventorymanagementbackend.repository;

import com.example.inventorymanagementbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryCategoryId(Long categoryId);
    List<Product> findBySupplierIdAndStockQuantityGreaterThan(Long supplierId, Integer minQuantity);
    List<Product> findByStatus(String status);
}