package com.backend.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.request.LoginRequestDTO;
import com.backend.dto.response.LoginResponseDTO;
import com.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
		log.info("Login attempt for user: {}", request.getUsername());
		LoginResponseDTO response = authService.login(request);
		return ResponseEntity.ok(response);
	}
}