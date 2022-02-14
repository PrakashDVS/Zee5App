package com.zee.zee5app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class LoginController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	
	@GetMapping("/mod")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
}