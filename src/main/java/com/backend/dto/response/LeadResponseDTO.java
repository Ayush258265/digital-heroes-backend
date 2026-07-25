package com.backend.dto.response;

import java.time.LocalDateTime;

public class LeadResponseDTO {
	private Long id;
	private String name;
	private String email;
	private String budgetRange;
	private String message;
	private String status;
	private LocalDateTime createdAt;

	// Default Constructor
	public LeadResponseDTO() {
	}

	// All-Args Constructor
	public LeadResponseDTO(Long id, String name, String email, String budgetRange, String message, String status,
			LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.budgetRange = budgetRange;
		this.message = message;
		this.status = status;
		this.createdAt = createdAt;
	}

	// Builder Pattern
	public static LeadResponseDTOBuilder builder() {
		return new LeadResponseDTOBuilder();
	}

	public static class LeadResponseDTOBuilder {
		private Long id;
		private String name;
		private String email;
		private String budgetRange;
		private String message;
		private String status;
		private LocalDateTime createdAt;

		public LeadResponseDTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public LeadResponseDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public LeadResponseDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public LeadResponseDTOBuilder budgetRange(String budgetRange) {
			this.budgetRange = budgetRange;
			return this;
		}

		public LeadResponseDTOBuilder message(String message) {
			this.message = message;
			return this;
		}

		public LeadResponseDTOBuilder status(String status) {
			this.status = status;
			return this;
		}

		public LeadResponseDTOBuilder createdAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public LeadResponseDTO build() {
			return new LeadResponseDTO(id, name, email, budgetRange, message, status, createdAt);
		}
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}