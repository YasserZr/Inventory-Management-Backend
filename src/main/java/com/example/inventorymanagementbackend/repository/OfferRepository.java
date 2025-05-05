package com.example.inventorymanagementbackend.repository;

import com.example.inventorymanagementbackend.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByProductId(Long productId);
    List<Offer> findBySupplierId(Long supplierId);
    List<Offer> findByStatus(String status);
    List<Offer> findByStartDateBeforeAndEndDateAfter(LocalDateTime currentDate, LocalDateTime currentDate2);
}