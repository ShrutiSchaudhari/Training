package com.concerto.excel_reader;

import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.excel_reader.model.Student;
import com.concerto.excel_reader.model.Teacher;

@RestController
@RequestMapping("api")
public class Controller {

	@Value("${excel.file.path.teacher-details}")
	private String teacherDetailsExcelFilePath;

	@Value("${excel.file.path.student-details}")
	private String studentDetailsExcelFilePath;
	@Autowired
	private ReadTeacherData readTeacherData;

	@Autowired
	private ReadStudentData readStudentData;

	@Autowired
	private GetExcel getExcel;

	// @GetMapping("/read")
	// public void readTeacherData() {
	//
	// List<Row> rows = getExcel.excelFile(teacherDetailsExcelFilePath);
	// boolean isFirstRow = true; // Flag to skip the first row (header row)
	//
	// for (Row r : rows) {
	// if (isFirstRow) {
	// // Set the flag to false after skipping the header row
	// isFirstRow = false;
	// // Skip the header row
	// continue;
	// }
	//
	// Teacher teacher = readTeacherData.readData(r);
	// System.out.println(teacher);
	// }
	//
	// }

	@GetMapping("/read/teachers")
	public void readTeacherData() {
		List<Teacher> teachers = getExcel.excelFile(teacherDetailsExcelFilePath, readTeacherData);
		for (Teacher teacher : teachers) {
			// Process and return teachers
			System.out.println(teacher);
		}
	}

	@GetMapping("/read/students")
	public void readStudentData() {
		List<Student> teachers = getExcel.excelFile(studentDetailsExcelFilePath, readStudentData);
		for (Student teacher : teachers) {
			// Process and return teachers
			System.out.println(teacher);
		}
	}
}
