package com.example.myproject.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id") // Explicitly naming
    private Long offerId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private User supplier;

    private Integer minimumQuantity;
    private BigDecimal discountValue;
    private String discountType; // e.g., Percentage, Fixed
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructors, Getters, and Setters
    public Offer(Long offerId, String title, String description, Product product, User supplier,
            Integer minimumQuantity, BigDecimal discountValue, String discountType, String status,
            LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.product = product;
        this.supplier = supplier;
        this.minimumQuantity = minimumQuantity;
        this.discountValue = discountValue;
        this.discountType = discountType;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

    public User getSupplier() {
        return supplier;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public String getDiscountType() {
        return discountType;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}