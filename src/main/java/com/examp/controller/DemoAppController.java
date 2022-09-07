package com.examp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examp.services.DemoAppServices;

@RestController
public class DemoAppController {
	
	@Autowired
	DemoAppServices demoService;
	
	@GetMapping("/getName/{name}")
	public String getName(@PathVariable String name) {
		return demoService.getName(name);
	}

}
