package com.example.myproject.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_order_lines")
public class PurchaseOrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pol_id") // Explicitly naming
    private Long polId;

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private BigDecimal taxRate;
    public PurchaseOrderLine() {
    }

    private BigDecimal discount;
    private BigDecimal finalPrice;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "po_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    public PurchaseOrderLine(Long polId, Integer quantity, BigDecimal unitPrice, BigDecimal totalPrice,
            BigDecimal taxRate, BigDecimal discount, BigDecimal finalPrice, LocalDateTime createdAt,
            LocalDateTime updatedAt, PurchaseOrder purchaseOrder, Product product) {
        this.polId = polId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.taxRate = taxRate;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.purchaseOrder = purchaseOrder;
        this.product = product;
    }
    public Long getPolId() {
        return polId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public BigDecimal getFinalPrice() {
        return finalPrice;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
    public Product getProduct() {
        return product;
    }

    // Constructors, Getters, and Setters
    
}