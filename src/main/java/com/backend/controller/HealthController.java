package com.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

	@GetMapping("/health")
	public Map<String, String> healthCheck() {
		Map<String, String> status = new HashMap<>();
		status.put("status", "UP");
		status.put("message", "LeadDesk Mini API is running");
		status.put("timestamp", String.valueOf(System.currentTimeMillis()));
		return status;
	}
}