package com.concerto.excel_reader;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.model.Student;
import com.concerto.excel_reader.model.Teacher;

@Component
public class ReadStudentData implements ExcelDataProcessor<Student> {

	@Override
	public Student processRow(Row row) {
		Student student = new Student();
		try {
			String id = row.getCell(0).toString();
			String name = row.getCell(1).toString();
			String email = row.getCell(2).toString();
			String contactNo = row.getCell(3).toString();
			

			student.setId(id);
			student.setName(name);
			student.setEmail(email);
			student.setContactNo(contactNo);

		} catch (Exception e) {
			System.out.println(e);
		}

		return student;
	}
}