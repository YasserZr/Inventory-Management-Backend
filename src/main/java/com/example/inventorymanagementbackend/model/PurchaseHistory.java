package com.example.inventorymanagementbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phId; // Renamed to avoid collision with User.id

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "purchaseHistory")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Default no-argument constructor required by JPA
    public PurchaseHistory() {
    }

    public PurchaseHistory(Long phId, User user, List<PurchaseOrder> purchaseOrders, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.phId = phId;
        this.user = user;
        this.purchaseOrders = purchaseOrders;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getPhId() {
        return phId;
    }

    public User getUser() {
        return user;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setPhId(Long phId) {
        this.phId = phId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}