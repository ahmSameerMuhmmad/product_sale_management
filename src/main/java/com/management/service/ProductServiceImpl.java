package com.management.service;

import com.management.Repository.ProductRepository;
import com.management.model.Product;
import com.management.model.Sale;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);
        return product;
    }

    @Override
    public String addProduct(Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        productRepository.save(product1);
        return "Successfully saved Product!";
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product product1 = productRepository.findById(id);
        if(product1 != null){
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setSales(product.getSales());
            return product1;
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public double getTotalRevenue() {
        List<Product> products = productRepository.findAll();
        double totalRevenue = 0;

        for (Product product : products) {
            totalRevenue += calculateProductRevenue(product);
        }

        return totalRevenue;
    }

    @Override
    public double getRevenueByProduct(Long productId) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            return calculateProductRevenue(product);
        }
        return 0;
    }

    public double calculateProductRevenue(Product product) {
        double productRevenue = 0;
        List<Sale> sales = product.getSales();

        if (sales != null) {
            for (Sale sale : sales) {
                productRevenue += sale.getQuantity() * product.getPrice();
            }
        }
        return productRevenue;
    }
}
