package com.sales.monitoring.sale;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;
    
    @PostMapping
    public Optional<SaleModel> createSale(@RequestBody SaleModel sale) {
        Optional<SaleModel> createdProduct = saleService.createSale(sale);

        return createdProduct;
    }
}


