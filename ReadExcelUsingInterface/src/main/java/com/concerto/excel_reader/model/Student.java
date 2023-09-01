package com.concerto.excel_reader.model;

public class Student {
	private String id;
	private String name;
	private String email;
	private String contactNo;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + "]";
	}

}