package com.concerto.exceldemo.model;

public class Teacher {

	
	private String id;
	private String name;
	private String qualification;


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


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", qualification=" + qualification + ",]";
	}
	
	
	
	
}
