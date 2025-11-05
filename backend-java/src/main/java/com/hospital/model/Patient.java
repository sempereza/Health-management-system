package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class Patient {
    
    @Id
    private String id;
    
    private String patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender; // Male, Female, Other
    private String bloodGroup; // A+, A-, B+, B-, AB+, AB-, O+, O-
    private String email;
    private String phone;
    private Address address;
    private EmergencyContact emergencyContact;
    private List<MedicalHistory> medicalHistory;
    private List<String> allergies;
    private List<Medication> currentMedications;
    private InsuranceDetails insuranceDetails;
    private LocalDate registrationDate;
    private String status; // Active, Inactive, Deceased
    private String userId;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmergencyContact {
        private String name;
        private String relationship;
        private String phone;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MedicalHistory {
        private String condition;
        private LocalDate diagnosedDate;
        private String treatment;
        private String notes;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Medication {
        private String medicationName;
        private String dosage;
        private String frequency;
        private String prescribedBy;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsuranceDetails {
        private String provider;
        private String policyNumber;
        private LocalDate validUntil;
    }
}
