package com.example.aparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 활성화
@EnableJpaAuditing
@SpringBootApplication
public class AparkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AparkingApplication.class, args);
    }

}
