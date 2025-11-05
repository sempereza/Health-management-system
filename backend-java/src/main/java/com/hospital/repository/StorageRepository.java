package com.hospital.repository;

import com.hospital.model.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StorageRepository extends MongoRepository<Storage, String> {
    Optional<Storage> findByItemId(String itemId);
    List<Storage> findByCategory(String category);
    List<Storage> findByStatus(String status);
    List<Storage> findByItemNameContainingIgnoreCase(String itemName);
}
