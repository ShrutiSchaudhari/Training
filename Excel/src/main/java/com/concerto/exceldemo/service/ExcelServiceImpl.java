package com.concerto.exceldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.exceldemo.model.Student;
import com.concerto.exceldemo.model.Teacher;
import com.concerto.exceldemo.repository.ExcelRepository;


@Service
public class ExcelServiceImpl implements ExcelService{

	@Autowired
	private  ExcelRepository excelRepository;
	
	 @Override
	    public List<Teacher> getAllTeachers(String filePath) {  
		 return excelRepository.readTeacherExcel(filePath);
	    }

	    @Override
	    public List<Student> getAllStudents(String filePath) {
	        return excelRepository.readStudentExcel(filePath);
	    }
}
