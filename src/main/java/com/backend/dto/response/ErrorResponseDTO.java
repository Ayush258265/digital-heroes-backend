package com.backend.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponseDTO {
	private int status;
	private String message;
	private Map<String, String> errors;
	private LocalDateTime timestamp;
	private String path;

	// Default Constructor
	public ErrorResponseDTO() {
	}

	// All-Args Constructor
	public ErrorResponseDTO(int status, String message, Map<String, String> errors, LocalDateTime timestamp,
			String path) {
		this.status = status;
		this.message = message;
		this.errors = errors;
		this.timestamp = timestamp;
		this.path = path;
	}

	// Builder Pattern
	public static ErrorResponseDTOBuilder builder() {
		return new ErrorResponseDTOBuilder();
	}

	public static class ErrorResponseDTOBuilder {
		private int status;
		private String message;
		private Map<String, String> errors;
		private LocalDateTime timestamp;
		private String path;

		public ErrorResponseDTOBuilder status(int status) {
			this.status = status;
			return this;
		}

		public ErrorResponseDTOBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ErrorResponseDTOBuilder errors(Map<String, String> errors) {
			this.errors = errors;
			return this;
		}

		public ErrorResponseDTOBuilder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ErrorResponseDTOBuilder path(String path) {
			this.path = path;
			return this;
		}

		public ErrorResponseDTO build() {
			return new ErrorResponseDTO(status, message, errors, timestamp, path);
		}
	}

	// Getters and Setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}