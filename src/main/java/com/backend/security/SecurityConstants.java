package com.backend.security;


public class SecurityConstants {
 public static final String[] PUBLIC_ENDPOINTS = {
     "/api/auth/login",
     "/api/leads"
 };
 
 public static final String[] ADMIN_ENDPOINTS = {
     "/api/leads/**"
 };
 
 public static final String BEARER_PREFIX = "Bearer ";
 public static final String AUTHORIZATION_HEADER = "Authorization";
}
