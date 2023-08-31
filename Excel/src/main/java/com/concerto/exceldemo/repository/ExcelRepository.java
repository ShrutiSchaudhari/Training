package com.concerto.exceldemo.repository;

import java.util.List;

import com.concerto.exceldemo.model.Student;
import com.concerto.exceldemo.model.Teacher;

public interface ExcelRepository {

	 List<Teacher> readTeacherExcel(String filePath);
	  List<Student> readStudentExcel(String filePath);
}
