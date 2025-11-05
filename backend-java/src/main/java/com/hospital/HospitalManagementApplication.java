package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class HospitalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
        System.out.println("\n" +
                "========================================\n" +
                "🏥 Health Management System - Java Backend\n" +
                "✅ Server running on http://localhost:8081\n" +
                "✅ MongoDB connected to hospitalDB\n" +
                "========================================\n");
    }
}
