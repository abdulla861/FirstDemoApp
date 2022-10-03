package com.examp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examp.model.MemberInfo;
import com.examp.repository.MemberRepository;
import com.examp.services.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRepository memberRepository;

	@PostMapping("/member/add")
	public ResponseEntity<MemberInfo> addUser(@RequestBody MemberInfo member) {
		
		try {
			MemberInfo memberInfo = memberRepository.save(new MemberInfo(member.getName(), member.getType()));
			return new ResponseEntity<>(memberInfo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/member/get/{name}")
	public ResponseEntity<List<MemberInfo>> findByName(@PathVariable String name) {
		try {
			List<MemberInfo> memberList = memberService.findByNameContainingIgnoreCase(name);
			if (memberList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(memberList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/member/getById/{id}")
	public ResponseEntity<MemberInfo> getTutorialById(@PathVariable int id) {
		Optional<MemberInfo> member = memberRepository.findById(id);
		if (member.isPresent()) {
			return new ResponseEntity<>(member.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/member/get")
	public ResponseEntity<List<MemberInfo>> getAll() {
		try {
			List<MemberInfo> memberList = memberRepository.findAll();
			if (memberList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(memberList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
