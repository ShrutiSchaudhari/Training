package com.concerto.exceldemo;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.exceldemo.model.Teacher;

@RestController
@RequestMapping("/excel")
public class Controller {

	@Value("${excel.teacher.file.path}")
	private String teacherFilePath;
	
	@Value("${excel.student.file.path}")
	private String studentFilePath;

	//this is the class and creating its instance we can acess its method 
	@Autowired
	ExcelRead excelread;
	
	@Autowired
	ReadTeacherData readTeacherData;
	

	 
	@GetMapping("/teacher")
	    public void readTeacherExcel() throws Exception {
		 try {
			List<Teacher> teachers= excelread.readExcelRow(teacherFilePath,0,readTeacherData);
			for (Teacher teacher : teachers) {
				// Process and return teachers
				System.out.println(teacher);
			}
			
		} catch (IOException  | InvalidFormatException  e) {
			
			e.printStackTrace();
		}
		
		 
	 }
	 }

