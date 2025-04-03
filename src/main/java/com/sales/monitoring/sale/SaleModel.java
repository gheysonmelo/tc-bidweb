package com.sales.monitoring.sale;

import com.sales.monitoring.product.ProductModel;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String saleDate;
    
    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductModel product;

    // Getters and Setters

    public long getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
