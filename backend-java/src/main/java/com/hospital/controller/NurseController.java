package com.hospital.controller;

import com.hospital.model.Nurse;
import com.hospital.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/nurses")
@CrossOrigin(origins = "*")
public class NurseController {
    
    @Autowired
    private NurseRepository nurseRepository;
    
    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseRepository.findAll();
        return ResponseEntity.ok(nurses);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable String id) {
        return nurseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Nurse>> getNursesByDepartment(@PathVariable String department) {
        List<Nurse> nurses = nurseRepository.findByDepartment(department);
        return ResponseEntity.ok(nurses);
    }
    
    @GetMapping("/shift/{shift}")
    public ResponseEntity<List<Nurse>> getNursesByShift(@PathVariable String shift) {
        List<Nurse> nurses = nurseRepository.findByShift(shift);
        return ResponseEntity.ok(nurses);
    }
    
    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
        Nurse savedNurse = nurseRepository.save(nurse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNurse);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable String id, @RequestBody Nurse nurseDetails) {
        return nurseRepository.findById(id)
                .map(nurse -> {
                    nurse.setFirstName(nurseDetails.getFirstName());
                    nurse.setLastName(nurseDetails.getLastName());
                    nurse.setEmail(nurseDetails.getEmail());
                    nurse.setPhone(nurseDetails.getPhone());
                    nurse.setDepartment(nurseDetails.getDepartment());
                    nurse.setQualification(nurseDetails.getQualification());
                    nurse.setSpecialization(nurseDetails.getSpecialization());
                    nurse.setYearsOfExperience(nurseDetails.getYearsOfExperience());
                    nurse.setShift(nurseDetails.getShift());
                    nurse.setAssignedWard(nurseDetails.getAssignedWard());
                    nurse.setStatus(nurseDetails.getStatus());
                    return ResponseEntity.ok(nurseRepository.save(nurse));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable String id) {
        if (nurseRepository.existsById(id)) {
            nurseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
