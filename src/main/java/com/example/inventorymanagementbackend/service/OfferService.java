package com.example.inventorymanagementbackend.service;

import com.example.inventorymanagementbackend.model.Offer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OfferService {
    List<Offer> getAllOffers();
    Optional<Offer> getOfferById(Long id);
    List<Offer> getActiveOffers(LocalDateTime currentDate);
    List<Offer> getOffersByProduct(Long productId);
    List<Offer> getOffersBySupplier(Long supplierId);
    List<Offer> getOffersByStatus(String status);
    Offer saveOffer(Offer offer);
    Offer updateOfferStatus(Long id, String status);
    void deleteOffer(Long id);
}