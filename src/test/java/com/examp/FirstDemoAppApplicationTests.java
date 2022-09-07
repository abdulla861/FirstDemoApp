package com.examp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examp.services.DemoAppServices;

@SpringBootTest
class FirstDemoAppApplicationTests {
	
	@Autowired
	DemoAppServices demoserv;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testGetName() {
		//mock(DemoAppServices.class).
		assertEquals("Demo Services for XYZ", demoserv.getName("XYZ"));
		
	}

}
