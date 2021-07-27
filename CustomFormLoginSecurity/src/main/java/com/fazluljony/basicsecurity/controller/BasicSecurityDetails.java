package com.fazluljony.basicsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicSecurityDetails {
	
	@GetMapping("/api")
	public String show()
	{  
		return "Code is working";
		
	}

	
}
