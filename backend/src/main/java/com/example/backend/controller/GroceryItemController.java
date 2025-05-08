package com.example.backend.controller;

import com.example.backend.model.GroceryItem;
import com.example.backend.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
@CrossOrigin(origins = "*") // For frontend integration
public class GroceryItemController {
    private final GroceryItemService groceryItemService;

    @Autowired
    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return ResponseEntity.ok(groceryItemService.getAllGroceryItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable String id) {
        return groceryItemService.getGroceryItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GroceryItem> createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(groceryItemService.createGroceryItem(groceryItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable String id, 
                                                        @RequestBody GroceryItem groceryItem) {
        return groceryItemService.updateGroceryItem(id, groceryItem)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable String id) {
        if (groceryItemService.deleteGroceryItem(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<GroceryItem>> getGroceryItemsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(groceryItemService.getGroceryItemsByCategory(category));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GroceryItem>> searchGroceryItems(@RequestParam String query) {
        return ResponseEntity.ok(groceryItemService.searchGroceryItems(query));
    }
}
