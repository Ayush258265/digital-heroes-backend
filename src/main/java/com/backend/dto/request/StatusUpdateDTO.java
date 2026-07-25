package com.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StatusUpdateDTO {

	@NotBlank(message = "Status is required")
	@Pattern(regexp = "NEW|CONTACTED|CLOSED", message = "Status must be NEW, CONTACTED, or CLOSED")
	private String status;

	// Default Constructor
	public StatusUpdateDTO() {
	}

	// All-Args Constructor
	public StatusUpdateDTO(String status) {
		this.status = status;
	}

	// Builder Pattern
	public static StatusUpdateDTOBuilder builder() {
		return new StatusUpdateDTOBuilder();
	}

	public static class StatusUpdateDTOBuilder {
		private String status;

		public StatusUpdateDTOBuilder status(String status) {
			this.status = status;
			return this;
		}

		public StatusUpdateDTO build() {
			return new StatusUpdateDTO(status);
		}
	}

	// Getters and Setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}