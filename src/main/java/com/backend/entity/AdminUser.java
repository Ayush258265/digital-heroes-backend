package com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_users")
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	// Default Constructor
	public AdminUser() {
	}

	// All-Args Constructor
	public AdminUser(Long id, String username, String passwordHash) {
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
	}

	// Builder Pattern
	public static AdminUserBuilder builder() {
		return new AdminUserBuilder();
	}

	public static class AdminUserBuilder {
		private Long id;
		private String username;
		private String passwordHash;

		public AdminUserBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public AdminUserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AdminUserBuilder passwordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}

		public AdminUser build() {
			return new AdminUser(id, username, passwordHash);
		}
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
}