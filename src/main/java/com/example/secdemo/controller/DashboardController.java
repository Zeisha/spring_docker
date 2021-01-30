package com.example.secdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/")
	 public String getDashboard() {
		 return "dashboard" ;
	 }
}
