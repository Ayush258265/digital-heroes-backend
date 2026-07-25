package com.backend.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

	@NotBlank(message = "Username is required")
	private String username;

	@NotBlank(message = "Password is required")
	private String password;

	// Default Constructor
	public LoginRequestDTO() {
	}

	// All-Args Constructor
	public LoginRequestDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Builder Pattern
	public static LoginRequestDTOBuilder builder() {
		return new LoginRequestDTOBuilder();
	}

	public static class LoginRequestDTOBuilder {
		private String username;
		private String password;

		public LoginRequestDTOBuilder username(String username) {
			this.username = username;
			return this;
		}

		public LoginRequestDTOBuilder password(String password) {
			this.password = password;
			return this;
		}

		public LoginRequestDTO build() {
			return new LoginRequestDTO(username, password);
		}
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}