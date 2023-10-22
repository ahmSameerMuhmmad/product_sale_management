package com.management.service;

import com.management.Repository.ProductRepository;
import com.management.Repository.SaleRepository;
import com.management.model.Product;
import com.management.model.Sale;
import com.management.model.SaleRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;
    @Override
    public String createSale(SaleRequestDTO saleRequest) {
        Product product = productRepository.findById(saleRequest.getProductId());
        int updatedQuantity = product.getQuantity() - saleRequest.getQuantity();
        product.setQuantity(updatedQuantity);
        productRepository.save(product);
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(saleRequest.getQuantity());
        sale.setSaleDate(saleRequest.getSaleDate());
        saleRepository.save(sale);
        return "Successfully created sale";
    }

}
