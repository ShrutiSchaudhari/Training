package com.concerto.exceldemo;



import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.exceldemo.model.Teacher;

@Component
public class ReadTeacherData implements ReadExcelData {
	
       
		@Override
		public Teacher processExcelRow(Row r) {
			
//		            Teacher teacher = new Teacher();
//		            teacher.setId(row.getCell(0).getStringCellValue());
//		            teacher.setName(rows.getCell(1).getStringCellValue());
//		            teacher.setQualification(rows.getCell(2).getStringCellValue());
//		           return teacher;
			 Teacher teacher = new Teacher();
			    DataFormatter dataFormatter = new DataFormatter();

			  
			        for (int i = 0; i < r.getLastCellNum(); i++) {
			            Cell cell = r.getCell(i);

			            if (cell != null) {
			                String cellValue = dataFormatter.formatCellValue(cell);

			                switch (i) {
			                    case 0:
			                        teacher.setId(cellValue);
			                        break;
			                    case 1:
			                        teacher.setName(cellValue);
			                        break;
			                    case 2:
			                        teacher.setQualification(cellValue);
			                        break;
			                    // Handle additional columns if needed
			                    default:
			                        // Handle or ignore other columns as needed
			                        break;
			                }
			            
			        }
			    }

			    return teacher;
			}
			






      }
	















//public void processExcelRow(String filePath, int sheetIndex, int rowNum) throws IOException {
 //   Row row = ExcelRead.readExcelRow(filePath, sheetIndex, rowNum);
    