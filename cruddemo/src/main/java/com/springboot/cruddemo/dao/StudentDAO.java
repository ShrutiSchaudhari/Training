package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String LastName);
	
	void update (Student theStudent);
	
	void delete (Integer id);
}
