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
@Document(collection = "admissions")
public class Admission {
    
    @Id
    private String id;
    
    private String admissionId;
    private String patientId;
    private String doctorId;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String ward;
    private String admissionType; // Emergency, Planned, Transfer
    private String diagnosis;
    private String treatment;
    private String status; // Admitted, Discharged, Transferred
    private String notes;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
