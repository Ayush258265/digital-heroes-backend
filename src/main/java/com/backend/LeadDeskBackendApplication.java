package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LeadDeskBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeadDeskBackendApplication.class, args);
    }
}