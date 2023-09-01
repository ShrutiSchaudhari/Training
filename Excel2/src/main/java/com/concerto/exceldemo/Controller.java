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
	private int sheetIndex;
	private int rowNum;
	 
	@Autowired
	ExcelRead excelread;
	
	@Autowired
	ReadTeacherData readTeacherData;
	 
	@GetMapping("/teacher")
	    public void readTeacherExcel() {
		 try {
			Row row= excelread.readExcelRow(teacherFilePath,0,1);
			Teacher teacher = readTeacherData.processExcelRow(row);
			System.out.println(teacher);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		 
	 }
	 }

