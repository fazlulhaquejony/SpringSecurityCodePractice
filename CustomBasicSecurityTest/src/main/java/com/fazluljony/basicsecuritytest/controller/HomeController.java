package com.fazluljony.basicsecuritytest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/api")
	public String  home()
	{
		return "test code is running, you can code";
	}
	
	@GetMapping("/manage")
	public String work()
	{
		return "Work method is working";
		
	}
	
	@GetMapping("/test")
	public String findhim()
	{
		return "findhim method is working";
		
	}
}
