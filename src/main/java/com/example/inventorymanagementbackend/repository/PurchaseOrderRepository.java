package com.example.inventorymanagementbackend.repository;

import com.example.inventorymanagementbackend.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findByOrderedById(Long userId);
    List<PurchaseOrder> findBySupplierId(Long supplierId);
    List<PurchaseOrder> findByStatus(String status);
    List<PurchaseOrder> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<PurchaseOrder> findByPaymentStatus(String paymentStatus);
}