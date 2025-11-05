package com.hospital.repository;

import com.hospital.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Optional<Payment> findByPaymentId(String paymentId);
    List<Payment> findByPatientId(String patientId);
    List<Payment> findByStatus(String status);
    List<Payment> findByPaymentType(String paymentType);
    Optional<Payment> findByInvoiceNumber(String invoiceNumber);
}
