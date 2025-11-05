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
@Document(collection = "payments")
public class Payment {
    
    @Id
    private String id;
    
    private String paymentId;
    private String patientId;
    private String patientName;
    private Double amount;
    private String paymentType; // Consultation, Surgery, Laboratory, Pharmacy, Room Charges, Emergency, X-Ray, Other
    private String paymentMethod; // Cash, Credit Card, Debit Card, Insurance, Bank Transfer, Online
    private String status; // Pending, Completed, Failed, Refunded
    private String transactionId;
    private String invoiceNumber;
    private String description;
    private LocalDate dueDate;
    private LocalDate paidDate;
    private InsuranceClaim insuranceClaim;
    private Double discount;
    private Double tax;
    private Double totalAmount;
    private String notes;
    private String processedBy;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsuranceClaim {
        private String claimId;
        private String provider;
        private Double claimAmount;
        private Double approvedAmount;
        private String status; // Submitted, Approved, Rejected, Pending
    }
}
