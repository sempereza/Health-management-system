package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctors")
public class Doctor {
    
    @Id
    private String id;
    
    private String doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String specialization;
    private String qualification;
    private String department;
    private Integer yearsOfExperience;
    private Double consultationFee;
    private List<String> availableDays;
    private List<TimeSlot> availableTimeSlots;
    private String licenseNumber;
    private LocalDate dateOfJoining;
    private String status; // Active, On Leave, Inactive
    private String userId;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeSlot {
        private String startTime;
        private String endTime;
    }
}
