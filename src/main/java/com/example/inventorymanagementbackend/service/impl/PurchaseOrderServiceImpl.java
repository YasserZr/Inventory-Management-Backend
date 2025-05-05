package com.example.inventorymanagementbackend.service.impl;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.PurchaseOrder;
import com.example.inventorymanagementbackend.repository.PurchaseOrderRepository;
import com.example.inventorymanagementbackend.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public Optional<PurchaseOrder> getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByUser(Long userId) {
        return purchaseOrderRepository.findByOrderedById(userId);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return purchaseOrderRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByStatus(String status) {
        return purchaseOrderRepository.findByStatus(status);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return purchaseOrderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersByPaymentStatus(String paymentStatus) {
        return purchaseOrderRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder.getPoId() == null) {
            purchaseOrder.setCreatedAt(LocalDateTime.now());
            // Set the order date to now if not provided
            if (purchaseOrder.getOrderDate() == null) {
                purchaseOrder.setOrderDate(LocalDateTime.now());
            }
        }
        purchaseOrder.setUpdatedAt(LocalDateTime.now());
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder updatePurchaseOrderStatus(Long id, String status) {
        return purchaseOrderRepository.findById(id)
                .map(order -> {
                    order.setStatus(status);
                    order.setUpdatedAt(LocalDateTime.now());
                    return purchaseOrderRepository.save(order);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Purchase Order", "id", id));
    }

    @Override
    public PurchaseOrder updatePurchaseOrderPaymentStatus(Long id, String paymentStatus) {
        return purchaseOrderRepository.findById(id)
                .map(order -> {
                    order.setPaymentStatus(paymentStatus);
                    order.setUpdatedAt(LocalDateTime.now());
                    return purchaseOrderRepository.save(order);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Purchase Order", "id", id));
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }
}