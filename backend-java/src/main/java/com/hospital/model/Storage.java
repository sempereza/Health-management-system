package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "storages")
public class Storage {
    
    @Id
    private String id;
    
    private String itemId;
    private String itemName;
    private String category; // Medicine, Equipment, Surgical Supplies, Laboratory, General
    private String description;
    private Integer quantity;
    private String unit; // Pieces, Boxes, Bottles, Packets, Strips, Vials, Sets
    private Integer minimumStockLevel;
    private Integer reorderLevel;
    private String supplier;
    private String manufacturer;
    private String batchNumber;
    private LocalDate expiryDate;
    private Double purchasePrice;
    private Double sellingPrice;
    private Location location;
    private LocalDate lastRestockDate;
    private String status; // In Stock, Low Stock, Out of Stock, Expired
    private String notes;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        private String building;
        private String floor;
        private String room;
        private String shelf;
    }
}
