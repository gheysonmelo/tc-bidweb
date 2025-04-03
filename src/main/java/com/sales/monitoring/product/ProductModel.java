package com.sales.monitoring.product;

import java.util.List;

import com.sales.monitoring.sale.SaleModel;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String productName;
    
    @Column(nullable = false)
    private float productValue;

    @OneToMany(mappedBy = "product")
    private List<SaleModel> sales;


    // Getters and Setters
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductValue() {
        return this.productValue;
    }

    public void setProductValue(float productValue) {
        this.productValue = productValue;
    }

    public long getId() {
        return this.id;
    }
}
