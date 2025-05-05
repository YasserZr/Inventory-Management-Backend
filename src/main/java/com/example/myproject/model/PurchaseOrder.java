package com.example.myproject.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_id") // Explicitly naming to avoid potential conflicts
    private Long poId;

    private String status;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String paymentStatus;
    private String paymentMethod;
    private String shippingAddress;
    private String billingAddress;
    private String notes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User orderedBy;

    @ManyToOne
    @JoinColumn(name = "supplier_id") // Assuming ordered from a supplier (User)
    private User supplier;

    @ManyToOne
    @JoinColumn(name = "ph_id") // Relationship with PurchaseHistory
    private PurchaseHistory purchaseHistory;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseOrderLine> purchaseOrderLines = new ArrayList<>();

    public PurchaseOrder(Long poId, String status, BigDecimal totalAmount, LocalDateTime orderDate,
            LocalDateTime deliveryDate, String paymentStatus, String paymentMethod, String shippingAddress,
            String billingAddress, String notes, LocalDateTime createdAt, LocalDateTime updatedAt, User orderedBy,
            User supplier, PurchaseHistory purchaseHistory, List<PurchaseOrderLine> purchaseOrderLines) {
        this.poId = poId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.orderedBy = orderedBy;
        this.supplier = supplier;
        this.purchaseHistory = purchaseHistory;
        this.purchaseOrderLines = purchaseOrderLines;
    }

    public Long getPoId() {
        return poId;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public User getSupplier() {
        return supplier;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public List<PurchaseOrderLine> getPurchaseOrderLines() {
        return purchaseOrderLines;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setOrderedBy(User orderedBy) {
        this.orderedBy = orderedBy;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public void setPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
        this.purchaseOrderLines = purchaseOrderLines;
    }

    // Constructors, Getters, and Setters
}