package com.concerto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.demo.entity.Student;
import com.concerto.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	@GetMapping("/student")
	public List<Student> listStudents(Model model) {
		
		return studentService.getAllStudents();
		
	}
	
}
