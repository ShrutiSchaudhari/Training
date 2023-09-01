package com.concerto.exceldemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExcelDemo {


	public static void main(String[] args) {
		SpringApplication.run(ExcelDemo.class, args);
		
		
		

	}

}


















//ReadTeacherData teacher = new ReadTeacherData();
//int sheetIndex = 0;
//int rowNum = 1;
//try {
//	teacher.processExcelRow(teacherFilePath, sheetIndex, rowNum);
//} catch (IOException e) {
//	e.printStackTrace();
//}