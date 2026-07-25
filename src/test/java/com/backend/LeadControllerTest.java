package com.backend;

import com.backend.dto.request.LeadRequestDTO;
import com.backend.repo.LeadRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class LeadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
        leadRepository.deleteAll();
    }

    @Test
    void createLead_Success() throws Exception {
        // Create DTO using constructor and setters instead of builder
        LeadRequestDTO request = new LeadRequestDTO();
        request.setName("John Doe");
        request.setEmail("john@example.com");
        request.setBudgetRange("$1k-$5k");
        request.setMessage("This is a valid message with more than 10 characters");

        mockMvc.perform(post("/api/leads")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.status").value("NEW"));
    }

    @Test
    void createLead_InvalidEmail() throws Exception {
        LeadRequestDTO request = new LeadRequestDTO();
        request.setName("John Doe");
        request.setEmail("invalid-email");
        request.setMessage("This is a valid message with more than 10 characters");

        mockMvc.perform(post("/api/leads")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.email").exists());
    }

    @Test
    void createLead_BlankMessage() throws Exception {
        LeadRequestDTO request = new LeadRequestDTO();
        request.setName("John Doe");
        request.setEmail("john@example.com");
        request.setMessage("short");

        mockMvc.perform(post("/api/leads")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.message").exists());
    }
}