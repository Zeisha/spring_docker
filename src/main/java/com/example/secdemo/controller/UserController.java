package com.example.secdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
	@GetMapping("/user")
	 public String getDashboard() {
		 return "user" ;
	 }
}
