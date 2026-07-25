package com.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "leads", indexes = { @Index(name = "idx_email", columnList = "email"),
		@Index(name = "idx_status", columnList = "status") })
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(nullable = false)
	private String email;

	@Column(name = "budget_range")
	private String budgetRange;

	@NotBlank(message = "Message is required")
	@Size(min = 10, message = "Message must be at least 10 characters")
	@Column(length = 1000, nullable = false)
	private String message;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private LeadStatus status = LeadStatus.NEW;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	public enum LeadStatus {
		NEW, CONTACTED, CLOSED
	}

	// Default Constructor
	public Lead() {
	}

	// All-Args Constructor
	public Lead(Long id, String name, String email, String budgetRange, String message, LeadStatus status,
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
	public static LeadBuilder builder() {
		return new LeadBuilder();
	}

	public static class LeadBuilder {
		private Long id;
		private String name;
		private String email;
		private String budgetRange;
		private String message;
		private LeadStatus status = LeadStatus.NEW;
		private LocalDateTime createdAt;

		public LeadBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public LeadBuilder name(String name) {
			this.name = name;
			return this;
		}

		public LeadBuilder email(String email) {
			this.email = email;
			return this;
		}

		public LeadBuilder budgetRange(String budgetRange) {
			this.budgetRange = budgetRange;
			return this;
		}

		public LeadBuilder message(String message) {
			this.message = message;
			return this;
		}

		public LeadBuilder status(LeadStatus status) {
			this.status = status;
			return this;
		}

		public LeadBuilder createdAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Lead build() {
			return new Lead(id, name, email, budgetRange, message, status, createdAt);
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

	public LeadStatus getStatus() {
		return status;
	}

	public void setStatus(LeadStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}