package com.sales.monitoring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductModel, Long> {
    Optional<ProductModel> findByProductName(String productName);
}