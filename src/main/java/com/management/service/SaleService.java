package com.management.service;

import com.management.model.Sale;
import com.management.model.SaleRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface SaleService {

    String createSale(SaleRequestDTO saleRequest);

}
