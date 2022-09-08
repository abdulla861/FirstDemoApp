package com.examp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.examp.model.MemberInfo;

@Repository
public interface MemberRepository extends JpaRepository<MemberInfo, Integer>, JpaSpecificationExecutor<MemberInfo> {
	
	List<MemberInfo> findByNameContainingIgnoreCase(String name);
	

}
