package com.example.inventorymanagementbackend.service.impl;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.Offer;
import com.example.inventorymanagementbackend.repository.OfferRepository;
import com.example.inventorymanagementbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Optional<Offer> getOfferById(Long id) {
        return offerRepository.findById(id);
    }

    @Override
    public List<Offer> getActiveOffers(LocalDateTime currentDate) {
        return offerRepository.findByStartDateBeforeAndEndDateAfter(currentDate, currentDate);
    }

    @Override
    public List<Offer> getOffersByProduct(Long productId) {
        return offerRepository.findByProductId(productId);
    }

    @Override
    public List<Offer> getOffersBySupplier(Long supplierId) {
        return offerRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<Offer> getOffersByStatus(String status) {
        return offerRepository.findByStatus(status);
    }

    @Override
    public Offer saveOffer(Offer offer) {
        if (offer.getOfferId() == null) {
            offer.setCreatedAt(LocalDateTime.now());
        }
        offer.setUpdatedAt(LocalDateTime.now());
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOfferStatus(Long id, String status) {
        return offerRepository.findById(id)
                .map(offer -> {
                    offer.setStatus(status);
                    offer.setUpdatedAt(LocalDateTime.now());
                    return offerRepository.save(offer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Offer", "id", id));
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}