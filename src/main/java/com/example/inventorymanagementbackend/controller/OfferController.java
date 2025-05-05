package com.example.inventorymanagementbackend.controller;

import com.example.inventorymanagementbackend.model.Offer;
import com.example.inventorymanagementbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Offer>> getActiveOffers(
            @RequestParam(required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currentDate) {
        
        // If currentDate is not provided, use the current system time
        if (currentDate == null) {
            currentDate = LocalDateTime.now();
        }
        
        return ResponseEntity.ok(offerService.getActiveOffers(currentDate));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Offer>> getOffersByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(offerService.getOffersByProduct(productId));
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Offer>> getOffersBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(offerService.getOffersBySupplier(supplierId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Offer>> getOffersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(offerService.getOffersByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.saveOffer(offer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.getOfferById(id)
                .map(existingOffer -> {
                    offer.setOfferId(id);
                    return ResponseEntity.ok(offerService.saveOffer(offer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Offer> updateOfferStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        try {
            Offer updatedOffer = offerService.updateOfferStatus(id, status);
            return ResponseEntity.ok(updatedOffer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(offer -> {
                    offerService.deleteOffer(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}