package com.concerto.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concerto.demo.entity.Student;

@Service
public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(int id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(int id);
}
