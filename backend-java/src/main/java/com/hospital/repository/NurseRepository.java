package com.hospital.repository;

import com.hospital.model.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String> {
    Optional<Nurse> findByNurseId(String nurseId);
    Optional<Nurse> findByEmail(String email);
    List<Nurse> findByStatus(String status);
    List<Nurse> findByDepartment(String department);
    List<Nurse> findByShift(String shift);
}
