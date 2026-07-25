package com.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LeadRequestDTO {

	@NotBlank(message = "Name is required")
	@Size(max = 100, message = "Name must not exceed 100 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Size(max = 100, message = "Email must not exceed 100 characters")
	private String email;

	private String budgetRange;

	@NotBlank(message = "Message is required")
	@Size(min = 10, max = 1000, message = "Message must be between 10 and 1000 characters")
	private String message;

	// Default Constructor
	public LeadRequestDTO() {
	}

	// All-Args Constructor
	public LeadRequestDTO(String name, String email, String budgetRange, String message) {
		this.name = name;
		this.email = email;
		this.budgetRange = budgetRange;
		this.message = message;
	}

	// Builder Pattern
	public static LeadRequestDTOBuilder builder() {
		return new LeadRequestDTOBuilder();
	}

	public static class LeadRequestDTOBuilder {
		private String name;
		private String email;
		private String budgetRange;
		private String message;

		public LeadRequestDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public LeadRequestDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public LeadRequestDTOBuilder budgetRange(String budgetRange) {
			this.budgetRange = budgetRange;
			return this;
		}

		public LeadRequestDTOBuilder message(String message) {
			this.message = message;
			return this;
		}

		public LeadRequestDTO build() {
			return new LeadRequestDTO(name, email, budgetRange, message);
		}
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBudgetRange() {
		return budgetRange;
	}

	public void setBudgetRange(String budgetRange) {
		this.budgetRange = budgetRange;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}