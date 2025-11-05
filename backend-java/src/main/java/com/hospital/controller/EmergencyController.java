package com.hospital.controller;

import com.hospital.model.Emergency;
import com.hospital.repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/emergencies")
@CrossOrigin(origins = "*")
public class EmergencyController {
    
    @Autowired
    private EmergencyRepository emergencyRepository;
    
    @GetMapping
    public ResponseEntity<List<Emergency>> getAllEmergencies() {
        List<Emergency> emergencies = emergencyRepository.findAll();
        return ResponseEntity.ok(emergencies);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Emergency> getEmergencyById(@PathVariable String id) {
        return emergencyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Emergency>> getEmergenciesByStatus(@PathVariable String status) {
        List<Emergency> emergencies = emergencyRepository.findByStatus(status);
        return ResponseEntity.ok(emergencies);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Emergency>> getActiveEmergencies() {
        List<Emergency> emergencies = emergencyRepository.findByStatus("Active");
        return ResponseEntity.ok(emergencies);
    }
    
    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Emergency>> getEmergenciesBySeverity(@PathVariable String severity) {
        List<Emergency> emergencies = emergencyRepository.findBySeverity(severity);
        return ResponseEntity.ok(emergencies);
    }
    
    @PostMapping
    public ResponseEntity<Emergency> createEmergency(@RequestBody Emergency emergency) {
        Emergency savedEmergency = emergencyRepository.save(emergency);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmergency);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Emergency> updateEmergency(@PathVariable String id, @RequestBody Emergency emergencyDetails) {
        return emergencyRepository.findById(id)
                .map(emergency -> {
                    emergency.setPatientName(emergencyDetails.getPatientName());
                    emergency.setAge(emergencyDetails.getAge());
                    emergency.setGender(emergencyDetails.getGender());
                    emergency.setEmergencyType(emergencyDetails.getEmergencyType());
                    emergency.setSeverity(emergencyDetails.getSeverity());
                    emergency.setChiefComplaint(emergencyDetails.getChiefComplaint());
                    emergency.setVitalSigns(emergencyDetails.getVitalSigns());
                    emergency.setSymptoms(emergencyDetails.getSymptoms());
                    emergency.setAllergies(emergencyDetails.getAllergies());
                    emergency.setTriageCategory(emergencyDetails.getTriageCategory());
                    emergency.setAssignedDoctor(emergencyDetails.getAssignedDoctor());
                    emergency.setAssignedNurse(emergencyDetails.getAssignedNurse());
                    emergency.setTreatment(emergencyDetails.getTreatment());
                    emergency.setDiagnosis(emergencyDetails.getDiagnosis());
                    emergency.setOutcome(emergencyDetails.getOutcome());
                    emergency.setStatus(emergencyDetails.getStatus());
                    emergency.setNotes(emergencyDetails.getNotes());
                    return ResponseEntity.ok(emergencyRepository.save(emergency));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergency(@PathVariable String id) {
        if (emergencyRepository.existsById(id)) {
            emergencyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
