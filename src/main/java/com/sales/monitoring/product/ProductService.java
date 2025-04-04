package com.sales.monitoring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public Optional<ProductModel> createProduct(ProductModel productModel) {
    Optional<ProductModel> existingProduct = productRepository.findByProductName(productModel.getProductName());


        if (existingProduct.isPresent()) {
            return existingProduct;
        } else {
            ProductModel createdProduct = productRepository.save(productModel);

            return Optional.ofNullable(createdProduct);
        }
    }

    public Optional<ProductModel> findByProductName(String productname) {
        return productRepository.findByProductName(productname);
    }

    public Optional<ProductModel> findById(long id) {
        return productRepository.findById(id);
    }

    public Iterable<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }
}
