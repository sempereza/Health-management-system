package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/patients")
@CrossOrigin(origins = "*")
public class PatientController {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return ResponseEntity.ok(patients);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/patientId/{patientId}")
    public ResponseEntity<Patient> getPatientByPatientId(@PathVariable String patientId) {
        return patientRepository.findByPatientId(patientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Patient>> getPatientsByStatus(@PathVariable String status) {
        List<Patient> patients = patientRepository.findByStatus(status);
        return ResponseEntity.ok(patients);
    }
    
    @GetMapping("/bloodGroup/{bloodGroup}")
    public ResponseEntity<List<Patient>> getPatientsByBloodGroup(@PathVariable String bloodGroup) {
        List<Patient> patients = patientRepository.findByBloodGroup(bloodGroup);
        return ResponseEntity.ok(patients);
    }
    
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patientDetails) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(patientDetails.getFirstName());
                    patient.setLastName(patientDetails.getLastName());
                    patient.setDateOfBirth(patientDetails.getDateOfBirth());
                    patient.setGender(patientDetails.getGender());
                    patient.setBloodGroup(patientDetails.getBloodGroup());
                    patient.setEmail(patientDetails.getEmail());
                    patient.setPhone(patientDetails.getPhone());
                    patient.setAddress(patientDetails.getAddress());
                    patient.setEmergencyContact(patientDetails.getEmergencyContact());
                    patient.setMedicalHistory(patientDetails.getMedicalHistory());
                    patient.setAllergies(patientDetails.getAllergies());
                    patient.setCurrentMedications(patientDetails.getCurrentMedications());
                    patient.setInsuranceDetails(patientDetails.getInsuranceDetails());
                    patient.setStatus(patientDetails.getStatus());
                    return ResponseEntity.ok(patientRepository.save(patient));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
