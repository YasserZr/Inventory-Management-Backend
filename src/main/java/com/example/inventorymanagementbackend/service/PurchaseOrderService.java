package com.example.inventorymanagementbackend.service;

import com.example.inventorymanagementbackend.model.PurchaseOrder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {
    List<PurchaseOrder> getAllPurchaseOrders();
    Optional<PurchaseOrder> getPurchaseOrderById(Long id);
    List<PurchaseOrder> getPurchaseOrdersByUser(Long userId);
    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);
    List<PurchaseOrder> getPurchaseOrdersByStatus(String status);
    List<PurchaseOrder> getPurchaseOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    List<PurchaseOrder> getPurchaseOrdersByPaymentStatus(String paymentStatus);
    PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder);
    PurchaseOrder updatePurchaseOrderStatus(Long id, String status);
    PurchaseOrder updatePurchaseOrderPaymentStatus(Long id, String paymentStatus);
    void deletePurchaseOrder(Long id);
}