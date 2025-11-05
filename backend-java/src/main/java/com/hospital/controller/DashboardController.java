package com.hospital.controller;

import com.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hospital/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private NurseRepository nurseRepository;
    
    @Autowired
    private EmergencyRepository emergencyRepository;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private AdmissionRepository admissionRepository;
    
    @Autowired
    private StorageRepository storageRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        stats.put("totalPatients", patientRepository.findByStatus("Active").size());
        stats.put("totalDoctors", doctorRepository.findByStatus("Active").size());
        stats.put("totalNurses", nurseRepository.findByStatus("Active").size());
        stats.put("activeEmergencies", emergencyRepository.findByStatus("Active").size());
        
        // Today's appointments
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        stats.put("todayAppointments", appointmentRepository.findByAppointmentDateBetween(startOfDay, endOfDay).size());
        
        stats.put("currentAdmissions", admissionRepository.findByStatus("Admitted").size());
        stats.put("lowStockItems", storageRepository.findByStatus("Low Stock").size());
        stats.put("pendingPayments", paymentRepository.findByStatus("Pending").size());
        
        return ResponseEntity.ok(stats);
    }
}
