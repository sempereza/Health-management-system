package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "appointments")
public class Appointment {
    
    @Id
    private String id;
    
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDateTime appointmentDate;
    private TimeSlot timeSlot;
    private String department;
    private String appointmentType; // Regular, Follow-up, Emergency, Consultation
    private String reason;
    private String status; // Scheduled, Confirmed, In Progress, Completed, Cancelled, No Show
    private String notes;
    private String createdBy;
    
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
