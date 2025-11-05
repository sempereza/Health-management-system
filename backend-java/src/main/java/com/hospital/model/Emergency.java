package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "emergencies")
public class Emergency {
    
    @Id
    private String id;
    
    private String emergencyId;
    private String patientId;
    private String patientName;
    private Integer age;
    private String gender;
    private LocalDateTime arrivalTime;
    private String emergencyType; // Accident, Heart Attack, Stroke, Severe Bleeding, etc.
    private String severity; // Critical, High, Medium, Low
    private String chiefComplaint;
    private VitalSigns vitalSigns;
    private List<String> symptoms;
    private List<String> allergies;
    private List<String> currentMedications;
    private String initialAssessment;
    private String triageCategory; // Red, Yellow, Green, Black
    private String assignedDoctor;
    private String assignedNurse;
    private List<Treatment> treatment;
    private List<LabTest> labTests;
    private String diagnosis;
    private String outcome; // Admitted, Discharged, Transferred, Referred, Death, In Progress
    private String admissionId;
    private LocalDateTime dischargeTime;
    private String notes;
    private String status; // Active, Resolved, Closed
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VitalSigns {
        private String bloodPressure;
        private Integer heartRate;
        private Double temperature;
        private Integer respiratoryRate;
        private Integer oxygenSaturation;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Treatment {
        private LocalDateTime time;
        private String action;
        private String medication;
        private String performedBy;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LabTest {
        private String testName;
        private String result;
        private LocalDateTime date;
    }
}
