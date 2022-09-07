package com.examp.services;

import org.springframework.stereotype.Service;

@Service
public class DemoAppServices {
	
	public String getName(String name) {
		return "Demo Services for " + name;
	}

}
