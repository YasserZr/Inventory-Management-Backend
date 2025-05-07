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

    @OneToMany(mappedBy = "orderedBy")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    @OneToMany(mappedBy = "supplier")
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

    // Builder pattern implementation
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User user = new User();

        public Builder username(String username) {
            user.setUsername(username);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public Builder firstname(String firstname) {
            user.setFirstname(firstname);
            return this;
        }

        public Builder lastname(String lastname) {
            user.setLastname(lastname);
            return this;
        }

        public Builder address(String address) {
            user.setAddress(address);
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            user.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder workAddress(String workAddress) {
            user.setWorkAddress(workAddress);
            return this;
        }

        public Builder companyContactNumber(String companyContactNumber) {
            user.setCompanyContactNumber(companyContactNumber);
            return this;
        }

        public Builder companyEmail(String companyEmail) {
            user.setCompanyEmail(companyEmail);
            return this;
        }

        public Builder role(String role) {
            user.setRole(role);
            return this;
        }

        public Builder rating(Double rating) {
            user.setRating(rating);
            return this;
        }

        public Builder serviceQuality(String serviceQuality) {
            user.setServiceQuality(serviceQuality);
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            user.setCreatedAt(createdAt);
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            user.setUpdatedAt(updatedAt);
            return this;
        }

        public Builder image(String image) {
            user.setImage(image);
            return this;
        }

        public User build() {
            return user;
        }
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