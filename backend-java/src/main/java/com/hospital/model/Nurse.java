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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "nurses")
public class Nurse {
    
    @Id
    private String id;
    
    private String nurseId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private String qualification;
    private String specialization;
    private Integer yearsOfExperience;
    private String shift; // Morning, Evening, Night, Rotational
    private String licenseNumber;
    private LocalDate dateOfJoining;
    private String assignedWard;
    private String status; // Active, On Leave, Inactive
    private String userId;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
