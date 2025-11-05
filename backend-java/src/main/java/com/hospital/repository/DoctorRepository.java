package com.hospital.repository;

import com.hospital.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findByDoctorId(String doctorId);
    Optional<Doctor> findByEmail(String email);
    List<Doctor> findByStatus(String status);
    List<Doctor> findByDepartment(String department);
    List<Doctor> findBySpecialization(String specialization);
}
