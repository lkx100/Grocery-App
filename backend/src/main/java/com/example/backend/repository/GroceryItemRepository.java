package com.example.backend.repository;

import java.util.List;

import com.example.backend.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {
    // Find items by category
    List<GroceryItem> findByCategory(String category);
    
    // Find items by name containing the given string (case-insensitive)
    List<GroceryItem> findByNameContainingIgnoreCase(String name);
    
    // Find active items below a certain price
    List<GroceryItem> findByIsActiveTrueAndPriceLessThan(Double price);
}
