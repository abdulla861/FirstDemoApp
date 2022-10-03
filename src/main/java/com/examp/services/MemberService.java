package com.examp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examp.model.MemberInfo;
import com.examp.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	public List<MemberInfo> findByNameContainingIgnoreCase(String name){
		return memberRepository.findByNameContainingIgnoreCase(name);
	}

}
