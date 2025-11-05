package com.hospital.repository;

import com.hospital.model.Emergency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmergencyRepository extends MongoRepository<Emergency, String> {
    Optional<Emergency> findByEmergencyId(String emergencyId);
    List<Emergency> findByStatus(String status);
    List<Emergency> findBySeverity(String severity);
    List<Emergency> findByPatientId(String patientId);
}
