package com.management.service;

import com.management.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    String addProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    double getTotalRevenue();

    double getRevenueByProduct(Long productId);

}
