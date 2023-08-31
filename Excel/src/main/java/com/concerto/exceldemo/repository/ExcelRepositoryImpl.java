package com.concerto.exceldemo.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Repository;

import com.concerto.exceldemo.model.Student;
import com.concerto.exceldemo.model.Teacher;


@Repository
public class ExcelRepositoryImpl  implements ExcelRepository{

	 @Override
	    public List<Teacher> readTeacherExcel(String filePath) {
	        List<Teacher> result = new ArrayList<>();

	      //upload the file 
	        try {
	            FileInputStream excelFile = new FileInputStream(new File(filePath));
	            Workbook workbook = WorkbookFactory.create(excelFile);
	            Sheet sheet = workbook.getSheetAt(0);

	            for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
//		        	  This condition is used to skip the first row of the sheet. 
//		        	  The assumption here is that the first row is a header row, 
//		        	  so  want to skip it when reading the actual data rows.
	            	
	            	if (index > 0) {
	            		
	            		//iterating the rows 
	                    Row row = sheet.getRow(index);
	                    Teacher teacher = new Teacher();
	                    teacher.setId(row.getCell(0).toString());
	                    teacher.setName(row.getCell(1).toString());
	                    teacher.setQualification(row.getCell(2).toString());
	                  

	                    result.add(teacher);
	                   // System.out.println(teacher);
	                }
	            }

	            workbook.close();
	            excelFile.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle the error
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    @Override
	    public List<Student> readStudentExcel(String filePath) {
	        List<Student> result = new ArrayList<>();

	        try {
	        	//upload the file 
	            FileInputStream excelFile = new FileInputStream(new File(filePath));
	            Workbook workbook = WorkbookFactory.create(excelFile);
	            Sheet sheet = workbook.getSheetAt(0);

	            for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
	                if (index > 0) {
	                	
	                	//iterating the rows 
	                    Row row = sheet.getRow(index);
	                    Student student = new Student();
	                    student.setId(row.getCell(0).toString());
	                    student.setName(row.getCell(1).toString());
	                    student.setStandard(row.getCell(2).toString());

	                    result.add(student);
	                   // System.out.println(student);
	                }
	            }

	            workbook.close();
	            excelFile.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle the error
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
}
//if(teacher.getId() != null && !teacher.getId().isEmpty() && !teacher.getName().isEmpty() && teacher.getName()!= null) {
//	teacher.setId(row.getCell(0).toString());
//    teacher.setName(row.getCell(1).toString());
//    teacher.setQualification(row.getCell(2).toString());
//}
//else {
//	System.out.println("Data is missing");
//}
