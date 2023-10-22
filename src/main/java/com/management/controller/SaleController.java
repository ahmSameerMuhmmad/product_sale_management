package com.management.controller;

import com.management.Repository.ProductRepository;
import com.management.model.SaleRequestDTO;
import com.management.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createSale(@RequestBody SaleRequestDTO saleRequest) {
        String createdSale = saleService.createSale(saleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);

    }
}
