package com.hospital.controller;

import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return ResponseEntity.ok(doctors);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        return doctorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/doctorId/{doctorId}")
    public ResponseEntity<Doctor> getDoctorByDoctorId(@PathVariable String doctorId) {
        return doctorRepository.findByDoctorId(doctorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(@PathVariable String department) {
        List<Doctor> doctors = doctorRepository.findByDepartment(department);
        return ResponseEntity.ok(doctors);
    }
    
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
        return ResponseEntity.ok(doctors);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Doctor>> getDoctorsByStatus(@PathVariable String status) {
        List<Doctor> doctors = doctorRepository.findByStatus(status);
        return ResponseEntity.ok(doctors);
    }
    
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setFirstName(doctorDetails.getFirstName());
                    doctor.setLastName(doctorDetails.getLastName());
                    doctor.setEmail(doctorDetails.getEmail());
                    doctor.setPhone(doctorDetails.getPhone());
                    doctor.setSpecialization(doctorDetails.getSpecialization());
                    doctor.setQualification(doctorDetails.getQualification());
                    doctor.setDepartment(doctorDetails.getDepartment());
                    doctor.setYearsOfExperience(doctorDetails.getYearsOfExperience());
                    doctor.setConsultationFee(doctorDetails.getConsultationFee());
                    doctor.setAvailableDays(doctorDetails.getAvailableDays());
                    doctor.setAvailableTimeSlots(doctorDetails.getAvailableTimeSlots());
                    doctor.setStatus(doctorDetails.getStatus());
                    return ResponseEntity.ok(doctorRepository.save(doctor));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
