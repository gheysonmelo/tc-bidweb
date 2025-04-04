package com.sales.monitoring.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping
    public Optional<ProductModel> createProduct(@RequestBody ProductModel product) {
        Optional<ProductModel> createdProduct = productService.createProduct(product);

        return createdProduct;
    }
    
    @GetMapping("/{productName}")
    public ResponseEntity<?> getProduct(@PathVariable String productName) {
        return productService.findByProductName(productName)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}


