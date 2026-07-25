package com.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.request.LeadRequestDTO;
import com.backend.dto.request.StatusUpdateDTO;
import com.backend.dto.response.LeadResponseDTO;
import com.backend.service.LeadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    
    // This is the correct way to initialize logger without Lombok
    private static final Logger log = LoggerFactory.getLogger(LeadController.class);
    
    private final LeadService leadService;
    
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }
    
    @PostMapping
    public ResponseEntity<LeadResponseDTO> createLead(@Valid @RequestBody LeadRequestDTO request) {
        log.info("Received lead submission from: {}", request.getEmail());
        LeadResponseDTO response = leadService.createLead(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<LeadResponseDTO>> getAllLeads(
            @RequestParam(required = false) String search) {
        log.info("Fetching leads with search: {}", search);
        List<LeadResponseDTO> leads = leadService.getAllLeads(search);
        return ResponseEntity.ok(leads);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<LeadResponseDTO> getLeadById(@PathVariable Long id) {
        log.info("Fetching lead with ID: {}", id);
        LeadResponseDTO lead = leadService.getLeadById(id);
        return ResponseEntity.ok(lead);
    }
    
    @PatchMapping("/{id}/status")
    public ResponseEntity<LeadResponseDTO> updateStatus(
            @PathVariable Long id, 
            @Valid @RequestBody StatusUpdateDTO statusUpdate) {
        log.info("Updating status for lead {} to: {}", id, statusUpdate.getStatus());
        LeadResponseDTO response = leadService.updateStatus(id, statusUpdate.getStatus());
        return ResponseEntity.ok(response);
    }
}