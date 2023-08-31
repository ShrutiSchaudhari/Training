package com.concerto.exceldemo.controller;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.exceldemo.model.Student;
import com.concerto.exceldemo.model.Teacher;
import com.concerto.exceldemo.service.ExcelService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("/excel")
public class ExcelController {
	
	@Autowired
	 private  ExcelService excelService;
	
	@Value("${excel.teacher.file.path}")
	private String teacherFilePath;
	
	@Value("${excel.student.file.path}")
	private String studentFilePath;
	
	 @GetMapping("/teacher")
	    public List<Teacher> readTeacherExcel() {
	        //String filePath = "C:\\Users\\shruti.chaudhari\\Desktop\\Training\\TeacherData.xlsx";
	        List<Teacher> teachers =  excelService.getAllTeachers(teacherFilePath);
	        if(!teachers.isEmpty() && teachers != null ) {
	        	for(Teacher teacher : teachers) {
	        		System.out.println(teacher);
	        	}
	        	
	        }
	        else {
        		System.out.println("Not data available");
        	}
	        return teachers;
	    }

	    @GetMapping("/student")
	    public List<Student> readStudentExcel() {
	       // String filePath = "C:\\Users\\shruti.chaudhari\\Desktop\\Training\\StudentData.xlsx";
	        List<Student> students =  excelService.getAllStudents(studentFilePath);
	        if(!students.isEmpty() && students != null ) {
	        	for(Student student : students) {
	        		System.out.println(student);
	        	}
	        }
	        else {
        		System.out.println("Not data available");
        	}
	        return students;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

//	@GetMapping("/teacher")
//	  public  List<Teacher> readTeacherExcel() {
//	      List<Teacher> result = new ArrayList<>();
//
//	      try {
//	          FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\shruti.chaudhari\\Desktop\\Training\\TeacherData.xlsx"));
//	          Workbook workbook = WorkbookFactory.create(excelFile);
//	          Sheet sheet = workbook.getSheetAt(0);
//
//	          for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
//		            if (index > 0) {
//		            	
//		         Row row = sheet.getRow(index);
//	        	 Teacher teacher = new Teacher();
//	        	 teacher.setId(row.getCell(0).toString());
//	        	 teacher.setName( row.getCell(1).toString());
//	        	 teacher.setQualification(row.getCell(2).toString());
//
//	        	 result.add(teacher);
//	        	 System.out.println(teacher);
//	        	
//	          }
//	          }
//
//	          workbook.close();
//	          excelFile.close();
//	      } catch (IOException e) {
//	          e.printStackTrace();
//	          // Handle the error
//	      } catch (EncryptedDocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	      return result;
//	  }
//	
//	@GetMapping("/student")
//	  public  List<Student> readStudentExcel()  {
//	      List<Student> result = new ArrayList<>();
//
//	      try {
//	          FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\shruti.chaudhari\\Desktop\\Training\\StudentData.xlsx"));
//	          Workbook workbook = WorkbookFactory.create(excelFile);
//	          //Workbook workbook = new XSSFWorkbook(excelFile);
//	          Sheet sheet = workbook.getSheetAt(0);
//
//	          for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
//		            
////	        	  This condition is used to skip the first row of the sheet. 
////	        	  The assumption here is that the first row is a header row, 
////	        	  so you want to skip it when reading the actual data rows.
//	        	  if (index > 0) {
//		            	
//		          Row row = sheet.getRow(index);
//		          Student student = new Student();
//		          student.setId(row.getCell(0).toString());
//		          student.setName( row.getCell(1).toString());
//		          student.setStandard(row.getCell(2).toString());
//
//	        	 result.add(student);
//	        	 System.out.println(student);
//	        	
//	          }
//	          }
//
//	          workbook.close();
//	          excelFile.close();
//	      } catch (IOException e) {
//	          e.printStackTrace();
//	          // Handle the error
//	      } catch (EncryptedDocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	      return result;
//	  }
