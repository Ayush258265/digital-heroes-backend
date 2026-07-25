package com.backend.service;

import com.backend.dto.request.LoginRequestDTO;
import com.backend.dto.response.LoginResponseDTO;
import com.backend.entity.AdminUser;
import com.backend.exception.InvalidCredentialsException;
import com.backend.repo.AdminUserRepository;
import com.backend.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	private static final Logger log = LoggerFactory.getLogger(AuthService.class);

	private final AdminUserRepository adminUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthService(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder,
			JwtService jwtService) {
		this.adminUserRepository = adminUserRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	public LoginResponseDTO login(LoginRequestDTO request) {
		log.info("Login attempt for username: {}", request.getUsername());

		AdminUser user = adminUserRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

		if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
			log.warn("Failed login attempt for username: {}", request.getUsername());
			throw new InvalidCredentialsException("Invalid username or password");
		}

		String token = jwtService.generateToken(user.getUsername());
		log.info("Successful login for username: {}", request.getUsername());

		return LoginResponseDTO.builder().token(token).username(user.getUsername()).message("Login successful").build();
	}
}