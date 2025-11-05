package com.hospital.repository;

import com.hospital.model.Admission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdmissionRepository extends MongoRepository<Admission, String> {
    Optional<Admission> findByAdmissionId(String admissionId);
    List<Admission> findByPatientId(String patientId);
    List<Admission> findByDoctorId(String doctorId);
    List<Admission> findByStatus(String status);
    List<Admission> findByWard(String ward);
}
