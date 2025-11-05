package com.hospital.controller;

import com.hospital.model.Admission;
import com.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/admissions")
@CrossOrigin(origins = "*")
public class AdmissionController {
    
    @Autowired
    private AdmissionRepository admissionRepository;
    
    @GetMapping
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        List<Admission> admissions = admissionRepository.findAll();
        return ResponseEntity.ok(admissions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Admission> getAdmissionById(@PathVariable String id) {
        return admissionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Admission>> getAdmissionsByPatient(@PathVariable String patientId) {
        List<Admission> admissions = admissionRepository.findByPatientId(patientId);
        return ResponseEntity.ok(admissions);
    }
    
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Admission>> getAdmissionsByDoctor(@PathVariable String doctorId) {
        List<Admission> admissions = admissionRepository.findByDoctorId(doctorId);
        return ResponseEntity.ok(admissions);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Admission>> getAdmissionsByStatus(@PathVariable String status) {
        List<Admission> admissions = admissionRepository.findByStatus(status);
        return ResponseEntity.ok(admissions);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Admission>> getActiveAdmissions() {
        List<Admission> admissions = admissionRepository.findByStatus("Admitted");
        return ResponseEntity.ok(admissions);
    }
    
    @PostMapping
    public ResponseEntity<Admission> createAdmission(@RequestBody Admission admission) {
        Admission savedAdmission = admissionRepository.save(admission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmission);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Admission> updateAdmission(@PathVariable String id, @RequestBody Admission admissionDetails) {
        return admissionRepository.findById(id)
                .map(admission -> {
                    admission.setDischargeDate(admissionDetails.getDischargeDate());
                    admission.setRoomNumber(admissionDetails.getRoomNumber());
                    admission.setBedNumber(admissionDetails.getBedNumber());
                    admission.setWard(admissionDetails.getWard());
                    admission.setAdmissionType(admissionDetails.getAdmissionType());
                    admission.setDiagnosis(admissionDetails.getDiagnosis());
                    admission.setTreatment(admissionDetails.getTreatment());
                    admission.setStatus(admissionDetails.getStatus());
                    admission.setNotes(admissionDetails.getNotes());
                    return ResponseEntity.ok(admissionRepository.save(admission));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmission(@PathVariable String id) {
        if (admissionRepository.existsById(id)) {
            admissionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
