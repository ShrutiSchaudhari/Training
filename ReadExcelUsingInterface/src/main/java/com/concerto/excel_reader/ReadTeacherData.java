package com.concerto.excel_reader;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.model.Teacher;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.model.Teacher;

@Component
public class ReadTeacherData implements ExcelDataProcessor<Teacher> {

    @Override
    public Teacher processRow(Row row) {
        Teacher teacher = new Teacher();
        try {
            String id = row.getCell(0).toString();
            String name = row.getCell(1).toString();
            String email = row.getCell(2).toString();
            String contactNo = row.getCell(3).toString();
            String subject = row.getCell(4).toString();

            teacher.setId(id);
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setContactNo(contactNo);
            teacher.setSubject(subject);

        } catch (Exception e) {
            System.out.println(e);
        }

        return teacher;
    }
}


//@Component
//public class ReadTeacherData implements ReadExcelFileData {
//	
//	public Teacher processRow(Row row) {
//		Teacher teacher = new Teacher();
//		try {
//			String id = row.getCell(0).toString();
//			String name = row.getCell(1).toString();
//			String email = row.getCell(2).toString();
//			String contactNo = row.getCell(3).toString();
//			String subject = row.getCell(4).toString();
//
//			teacher.setId(id);
//			teacher.setName(name);
//			teacher.setEmail(email);
//			teacher.setContactNo(contactNo);
//			teacher.setSubject(subject);
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return teacher;
//	}
//
//
//
//}
