package com.hospital.repository;

import com.hospital.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByPatientId(String patientId);
    Optional<Patient> findByEmail(String email);
    List<Patient> findByStatus(String status);
    List<Patient> findByBloodGroup(String bloodGroup);
}
