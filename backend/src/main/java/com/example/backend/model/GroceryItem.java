package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "GroceryItem")
public class GroceryItem {
    @Id
    private String id;

    private String name;
    private String category;
    private Double price;
    private int stockQuantity;
    private String imageUrl;
    private boolean isActive;
    private Date createdAt;

    // Constructor
    public GroceryItem() {
        this.createdAt = new Date();
        this.isActive = true;
        this.price = 0.00;
    }

    // Constructor when object is created
    public GroceryItem(String name, Double price, String category, int stockQuantity, String imageUrl) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    public Boolean isActive() {
        return isActive;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantityInStock=" + stockQuantity +
                '}';
    }
}
