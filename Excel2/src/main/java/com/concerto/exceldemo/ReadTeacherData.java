package com.concerto.exceldemo;



import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.exceldemo.model.Teacher;

@Component
public class ReadTeacherData implements ReadExcelData {
	
       
		@Override
		public Teacher processExcelRow(Row row) {
		            Teacher teacher = new Teacher();
		            teacher.setId(row.getCell(0).getStringCellValue());
		            teacher.setName(row.getCell(1).getStringCellValue());
		            teacher.setQualification(row.getCell(2).getStringCellValue());

		           return teacher;
		}

      }
	















//public void processExcelRow(String filePath, int sheetIndex, int rowNum) throws IOException {
 //   Row row = ExcelRead.readExcelRow(filePath, sheetIndex, rowNum);
    