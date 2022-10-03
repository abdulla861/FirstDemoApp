package com.examp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MemberInfo")
public class MemberInfo {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	//like admin or user
	@Column(name = "Type")
	private String type;

	public MemberInfo() {
	}
	
	

	public MemberInfo(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}



	public MemberInfo(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
}
