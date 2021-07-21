package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth")
public class noAuthController {

	
	@GetMapping("/sayHi")
	public String sayHi()
	{
		return"hi no auth controller executed";
	}
}
