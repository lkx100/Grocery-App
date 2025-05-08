package com.example.backend.service;

import com.example.backend.model.GroceryItem;
import com.example.backend.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getGroceryItemById(String id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        // Ensure new items have proper creation timestamp
        groceryItem.setCreatedAt(new Date());
        return groceryItemRepository.save(groceryItem);
    }

    public Optional<GroceryItem> updateGroceryItem(String id, GroceryItem updatedItem) {
        return groceryItemRepository.findById(id)
                .map(existingItem -> {
                    // Update properties
                    if (updatedItem.getName() != null) {
                        existingItem.setName(updatedItem.getName());
                    }
                    if (updatedItem.getCategory() != null) {
                        existingItem.setCategory(updatedItem.getCategory());
                    }
                    if (updatedItem.getPrice() != null) {
                        existingItem.setPrice(updatedItem.getPrice());
                    }
                    if (updatedItem.getStockQuantity() != null) {
                        existingItem.setStockQuantity(updatedItem.getStockQuantity());
                    }
                    if (updatedItem.isActive() != null) {
                        existingItem.setActive(updatedItem.isActive());
                    }
                    
                    // Save and return updated item
                    return groceryItemRepository.save(existingItem);
                });
    }

    public boolean deleteGroceryItem(String id) {
        if (groceryItemRepository.existsById(id)) {
            groceryItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Additional business methods
    public List<GroceryItem> getGroceryItemsByCategory(String category) {
        return groceryItemRepository.findByCategory(category);
    }

    public List<GroceryItem> searchGroceryItems(String keyword) {
        return groceryItemRepository.findByNameContainingIgnoreCase(keyword);
    }    
}
