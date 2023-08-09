package com.concerto.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lasttName;
	
	@Column(name="email")
	private String emailId;


	//constructors
	public Student( String firstName, String lasttName, String emailId) {
		
		
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.emailId = emailId;
	}

	public Student(int id, String firstName, String lasttName, String emailId) {
		
		this.id = id;
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.emailId = emailId;
	}
	
	public Student() {
		System.out.println(" Default Constuctor");
	}
	
	//getter setter
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	//toString()
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", emailId=" + emailId
				+ "]";
	}
	
	

}
