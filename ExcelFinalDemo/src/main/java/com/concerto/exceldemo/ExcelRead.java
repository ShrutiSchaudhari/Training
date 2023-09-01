package com.concerto.exceldemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component
public class ExcelRead {

	public  List<Row> readExcelRow(String filePath, int sheetIndex) throws IOException, Exception, InvalidFormatException {
		 List<Row> rows = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        boolean isFirstRow = true; // Flag to skip the first row (header row)

        for (Row row : sheet) {
            if (isFirstRow) {
                isFirstRow = false; // Set the flag to false after skipping the header row
                continue; // Skip the header row
            }
        	
        	rows.add(row);	
        }
        workbook.close();
        fileInputStream.close();
        return rows;
    }
}
