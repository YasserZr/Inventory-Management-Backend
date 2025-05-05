package com.example.inventorymanagementbackend.controller;

import com.example.inventorymanagementbackend.model.PurchaseOrder;
import com.example.inventorymanagementbackend.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersByUser(userId));
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersBySupplier(supplierId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersByDateRange(startDate, endDate));
    }

    @GetMapping("/payment-status/{paymentStatus}")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrdersByPaymentStatus(@PathVariable String paymentStatus) {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersByPaymentStatus(paymentStatus));
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return new ResponseEntity<>(purchaseOrderService.savePurchaseOrder(purchaseOrder), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        try {
            PurchaseOrder updatedOrder = purchaseOrderService.updatePurchaseOrderStatus(id, status);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/payment-status")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrderPaymentStatus(
            @PathVariable Long id,
            @RequestParam String paymentStatus) {
        try {
            PurchaseOrder updatedOrder = purchaseOrderService.updatePurchaseOrderPaymentStatus(id, paymentStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id)
                .map(order -> {
                    purchaseOrderService.deletePurchaseOrder(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
