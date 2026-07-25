package com.backend.dto.response;

public class LoginResponseDTO {
	private String token;
	private String username;
	private String message;

	// Default Constructor
	public LoginResponseDTO() {
	}

	// All-Args Constructor
	public LoginResponseDTO(String token, String username, String message) {
		this.token = token;
		this.username = username;
		this.message = message;
	}

	// Builder Pattern
	public static LoginResponseDTOBuilder builder() {
		return new LoginResponseDTOBuilder();
	}

	public static class LoginResponseDTOBuilder {
		private String token;
		private String username;
		private String message;

		public LoginResponseDTOBuilder token(String token) {
			this.token = token;
			return this;
		}

		public LoginResponseDTOBuilder username(String username) {
			this.username = username;
			return this;
		}

		public LoginResponseDTOBuilder message(String message) {
			this.message = message;
			return this;
		}

		public LoginResponseDTO build() {
			return new LoginResponseDTO(token, username, message);
		}
	}

	// Getters and Setters
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}