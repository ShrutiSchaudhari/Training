package com.concerto.excel_reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.model.Teacher;

import com.concerto.excel_reader.ExcelDataProcessor; // Import the ExcelDataProcessor interface

@Component
public class GetExcel {

    public <T> List<T> excelFile(String excelFilePath, ExcelDataProcessor<T> dataProcessor) {
        List<T> processedData = new ArrayList<>();
        FileInputStream excelFile;

        try {
            excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            // Start from the second row (index 1) to skip the header
            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    T processedRow = dataProcessor.processRow(row);
                    processedData.add(processedRow);
                }
            }
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }

        return processedData;
    }
}
