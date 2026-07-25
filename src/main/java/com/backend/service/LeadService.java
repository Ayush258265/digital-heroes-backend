package com.backend.service;

import com.backend.dto.request.LeadRequestDTO;
import com.backend.dto.response.LeadResponseDTO;
import com.backend.entity.Lead;
import com.backend.exception.ResourceNotFoundException;
import com.backend.repo.LeadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeadService {
    
    private static final Logger log = LoggerFactory.getLogger(LeadService.class);
    
    private final LeadRepository leadRepository;
    
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }
    
    @Transactional
    public LeadResponseDTO createLead(LeadRequestDTO request) {
        log.info("Creating new lead for: {}", request.getEmail());
        
        Lead lead = Lead.builder()
            .name(request.getName())
            .email(request.getEmail())
            .budgetRange(request.getBudgetRange())
            .message(request.getMessage())
            .status(Lead.LeadStatus.NEW)
            .build();
        
        Lead savedLead = leadRepository.save(lead);
        log.info("Lead created with ID: {}", savedLead.getId());
        
        return convertToResponseDTO(savedLead);
    }
    
    @Transactional(readOnly = true)
    public List<LeadResponseDTO> getAllLeads(String search) {
        log.debug("Fetching all leads with search: {}", search);
        
        List<Lead> leads;
        if (search != null && !search.trim().isEmpty()) {
            leads = leadRepository.searchByNameOrEmail(search.trim());
        } else {
            leads = leadRepository.findAll();
        }
        
        return leads.stream()
            .map(this::convertToResponseDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public LeadResponseDTO updateStatus(Long id, String status) {
        log.info("Updating lead {} status to: {}", id, status);
        
        Lead lead = leadRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Lead not found with ID: " + id));
        
        lead.setStatus(Lead.LeadStatus.valueOf(status));
        Lead updatedLead = leadRepository.save(lead);
        
        log.info("Lead {} status updated successfully", id);
        return convertToResponseDTO(updatedLead);
    }
    
    @Transactional(readOnly = true)
    public LeadResponseDTO getLeadById(Long id) {
        Lead lead = leadRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Lead not found with ID: " + id));
        return convertToResponseDTO(lead);
    }
    
    private LeadResponseDTO convertToResponseDTO(Lead lead) {
        return LeadResponseDTO.builder()
            .id(lead.getId())
            .name(lead.getName())
            .email(lead.getEmail())
            .budgetRange(lead.getBudgetRange())
            .message(lead.getMessage())
            .status(lead.getStatus().name())
            .createdAt(lead.getCreatedAt())
            .build();
    }
}