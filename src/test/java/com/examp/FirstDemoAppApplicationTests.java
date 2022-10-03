package com.examp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examp.model.MemberInfo;
import com.examp.repository.MemberRepository;
import com.examp.services.DemoAppServices;
import com.examp.services.MemberService;

@SpringBootTest
class FirstDemoAppApplicationTests {
	
	@Autowired
	DemoAppServices demoserv;

	@Test
	void contextLoads() {
	}
	
	@Test
	@Disabled
	void testGetName() {
		//mock(DemoAppServices.class).
		assertEquals("Demo Services for XYZ", demoserv.getName("XYZ"));
		
	}
	
	
	@Mock
	MemberRepository memberRepository;
	
	@InjectMocks
	MemberService memberService;

	@Test
	void testFindByNameContainingIgnoreCase() {
		
		when(memberRepository.findByNameContainingIgnoreCase("abd")).thenReturn(Stream.of(
				new MemberInfo(1, "abd", "admin"),new MemberInfo(2, "abd2", "admin"),
				new MemberInfo(3, "abd", "admin")).collect(Collectors.toList()));
		
		assertEquals(3, memberService.findByNameContainingIgnoreCase("abd").size());
		
		verify(memberRepository, times(1)).findByNameContainingIgnoreCase("abd");
		
	}

}
