package com.example.inventorymanagementbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String firstname;
    private String lastname;
    private String address;

    @Column(unique = true)
    private String phoneNumber;

    private String workAddress;

    @Column(unique = true)
    private String companyContactNumber;

    @Column(unique = true)
    private String companyEmail;

    private String role;
    private Double rating;
    private String serviceQuality;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String image;

    // No direct mapping for methods in the model
    // (Authenticate(), Activate_user(roles), etc.)
    // These would typically be part of service layer logic

    @OneToMany(mappedBy = "orderedBy")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    @OneToMany(mappedBy = "supplier") // Assuming User is a supplier and makes Offers
    private List<Offer> offersMade = new ArrayList<>();

    // Default no-argument constructor required by JPA
    public User() {
    }

    public User(Long id, String username, String email, String password, String firstname, String lastname,
            String address, String phoneNumber, String workAddress, String companyContactNumber, String companyEmail,
            String role, Double rating, String serviceQuality, LocalDateTime createdAt, LocalDateTime updatedAt,
            String image, List<PurchaseOrder> purchaseOrders, List<Offer> offersMade) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.workAddress = workAddress;
        this.companyContactNumber = companyContactNumber;
        this.companyEmail = companyEmail;
        this.role = role;
        this.rating = rating;
        this.serviceQuality = serviceQuality;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.image = image;
        this.purchaseOrders = purchaseOrders;
        this.offersMade = offersMade;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public String getCompanyContactNumber() {
        return companyContactNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getRole() {
        return role;
    }

    public Double getRating() {
        return rating;
    }

    public String getServiceQuality() {
        return serviceQuality;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getImage() {
        return image;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public List<Offer> getOffersMade() {
        return offersMade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public void setCompanyContactNumber(String companyContactNumber) {
        this.companyContactNumber = companyContactNumber;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setServiceQuality(String serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public void setOffersMade(List<Offer> offersMade) {
        this.offersMade = offersMade;
    }
}