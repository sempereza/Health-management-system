package com.hospital.controller;

import com.hospital.model.Payment;
import com.hospital.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return ResponseEntity.ok(payments);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        return paymentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Payment>> getPaymentsByPatient(@PathVariable String patientId) {
        List<Payment> payments = paymentRepository.findByPatientId(patientId);
        return ResponseEntity.ok(payments);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(@PathVariable String status) {
        List<Payment> payments = paymentRepository.findByStatus(status);
        return ResponseEntity.ok(payments);
    }
    
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody Payment paymentDetails) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setAmount(paymentDetails.getAmount());
                    payment.setPaymentType(paymentDetails.getPaymentType());
                    payment.setPaymentMethod(paymentDetails.getPaymentMethod());
                    payment.setStatus(paymentDetails.getStatus());
                    payment.setTransactionId(paymentDetails.getTransactionId());
                    payment.setDescription(paymentDetails.getDescription());
                    payment.setPaidDate(paymentDetails.getPaidDate());
                    payment.setInsuranceClaim(paymentDetails.getInsuranceClaim());
                    payment.setDiscount(paymentDetails.getDiscount());
                    payment.setTax(paymentDetails.getTax());
                    payment.setTotalAmount(paymentDetails.getTotalAmount());
                    payment.setNotes(paymentDetails.getNotes());
                    return ResponseEntity.ok(paymentRepository.save(payment));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable String id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
