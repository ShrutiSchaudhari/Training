package com.concerto.exceldemo.service;

import java.util.List;

import com.concerto.exceldemo.model.Student;
import com.concerto.exceldemo.model.Teacher;

public interface ExcelService {

	
	 List<Teacher> getAllTeachers(String filePath);
	  List<Student> getAllStudents(String filePath);
}
