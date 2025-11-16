package com.model;

import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {
	private  int id;
	private String name;
	private String email;
	private String contact;
	
	public Employee() {
		// TODO Auto-generated constructor stub 
	}
	
	public Employee(String name, String email, String contact) {
		this.name = name;
		this.email = email;
		this.contact = contact;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
