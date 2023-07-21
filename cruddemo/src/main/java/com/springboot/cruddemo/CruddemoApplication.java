package com.springboot.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {
		
		return runner ->{
		//	createStudent(studentDAO);
		//	readStudent(studentDAO);
		//	queryForStudent(studentDAO);
		//	queryForStudentsByLastName(studentDAO);
		//	updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
		
	}
	private void updateStudent(StudentDAO studentDAO) {
		// retrieve data based on ID
		int studentId= 1;
		System.out.println("Getting student id : "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		//CHANGE name 
		System.out.println("Updating Student");
		//myStudent.setFirstName("Monica");
		myStudent.setEmailId("monica@gmail.com");
		
		//update student
		System.out.println("Student Updated");
		studentDAO.update(myStudent);
		//display
		System.out.println("Updation complete : "+myStudent);
		
	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students 
		List<Student> theStudents = studentDAO.findByLastName("Bing");
		//display
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		
	}
	private void queryForStudent(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findAll();
		
		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	
	//read data
	private void readStudent(StudentDAO studentDAO) {
		//create the student object 
				System.out.println("creating new student");
				Student tempStudent= new Student("Joey" ,  "Tribianni" ,"joey@gmail.com");
			
				// Save the student object
				System.out.println("saving the student");
				studentDAO.save(tempStudent);
				
				//display the saved object
				int theId= tempStudent.getId();
				System.out.println("Saved Student id :'"+ theId);
			
				//retrieve data
				System.out.println("Retrieving student data :'"+theId);
				Student myStudent = studentDAO.findById(theId);
				
				//display student
				System.out.println("Found the student: " +myStudent);
	}
	
	
	
	//create student method
	private void createStudent(StudentDAO studentDAO) {
		
		//create the student object 
		System.out.println("creating new student");
		Student tempStudent= new Student("Chandler" ,  "Bing" ,"chandlarbing@gmail.com");
	
		// Save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		
		//display the saved object
		System.out.println("Saved Student id :'"+tempStudent.getId());
	
	}

}
