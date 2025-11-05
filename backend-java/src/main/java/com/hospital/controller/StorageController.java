package com.hospital.controller;

import com.hospital.model.Storage;
import com.hospital.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/storage")
@CrossOrigin(origins = "*")
public class StorageController {
    
    @Autowired
    private StorageRepository storageRepository;
    
    @GetMapping
    public ResponseEntity<List<Storage>> getAllStorageItems() {
        List<Storage> items = storageRepository.findAll();
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorageItemById(@PathVariable String id) {
        return storageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Storage>> getStorageItemsByCategory(@PathVariable String category) {
        List<Storage> items = storageRepository.findByCategory(category);
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Storage>> getStorageItemsByStatus(@PathVariable String status) {
        List<Storage> items = storageRepository.findByStatus(status);
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/low-stock")
    public ResponseEntity<List<Storage>> getLowStockItems() {
        List<Storage> items = storageRepository.findByStatus("Low Stock");
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Storage>> searchStorageItems(@PathVariable String name) {
        List<Storage> items = storageRepository.findByItemNameContainingIgnoreCase(name);
        return ResponseEntity.ok(items);
    }
    
    @PostMapping
    public ResponseEntity<Storage> createStorageItem(@RequestBody Storage storage) {
        Storage savedStorage = storageRepository.save(storage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStorage);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Storage> updateStorageItem(@PathVariable String id, @RequestBody Storage storageDetails) {
        return storageRepository.findById(id)
                .map(storage -> {
                    storage.setItemName(storageDetails.getItemName());
                    storage.setCategory(storageDetails.getCategory());
                    storage.setDescription(storageDetails.getDescription());
                    storage.setQuantity(storageDetails.getQuantity());
                    storage.setUnit(storageDetails.getUnit());
                    storage.setMinimumStockLevel(storageDetails.getMinimumStockLevel());
                    storage.setReorderLevel(storageDetails.getReorderLevel());
                    storage.setSupplier(storageDetails.getSupplier());
                    storage.setManufacturer(storageDetails.getManufacturer());
                    storage.setBatchNumber(storageDetails.getBatchNumber());
                    storage.setExpiryDate(storageDetails.getExpiryDate());
                    storage.setPurchasePrice(storageDetails.getPurchasePrice());
                    storage.setSellingPrice(storageDetails.getSellingPrice());
                    storage.setLocation(storageDetails.getLocation());
                    storage.setStatus(storageDetails.getStatus());
                    storage.setNotes(storageDetails.getNotes());
                    return ResponseEntity.ok(storageRepository.save(storage));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorageItem(@PathVariable String id) {
        if (storageRepository.existsById(id)) {
            storageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
