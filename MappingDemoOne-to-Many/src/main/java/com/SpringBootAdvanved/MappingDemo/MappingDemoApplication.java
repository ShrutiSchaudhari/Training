package com.SpringBootAdvanved.MappingDemo;

import java.rmi.StubNotFoundException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SpringBootAdvanved.MappingDemo.dao.AppDAO;
import com.SpringBootAdvanved.MappingDemo.entity.Course;
import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;
import com.SpringBootAdvanved.MappingDemo.entity.Student;

@SpringBootApplication
public class MappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingDemoApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(AppDAO appDAO) {
			return runner->{
			
				createCourseAndStudent(appDAO);
				
		};
	
	
	
	
}
		private void createCourseAndStudent(AppDAO appDAO) {
			
			//create course
			Course tempCourse = new Course("Sql");
			
			//create students
			
			Student tempStudent = new Student("John","Doe","john@gmail.com");
			Student tempStudent1 = new Student("Mary","Public","mary@gmail.com");
			tempCourse.addStudents(tempStudent);
			tempCourse.addStudents(tempStudent1);
		
			System.out.println("saving the course :"+tempCourse);
			System.out.println("associated students :"+tempCourse.getStudents());
			
			appDAO.save(tempCourse);
			 System.out.println("done!");
			
		}
		private void deleteCourse(AppDAO appDAO) {
			 int theId = 10;
			 //find
			 System.out.println("deleting the course id "+theId);
			
			 appDAO.deleteCourseById(theId);
			 System.out.println("done!");
		}
		private void updateCourse(AppDAO appDAO) {
			
			int theId=10;
			//find
			System.out.println("Findiing the course id:"+theId);
			Course tempCourse = appDAO.findCourseById(theId);
			//update
			System.out.println("Updating course id:"+theId);
			tempCourse.setTitle("qwerty");
			//final update method from dao
			appDAO.update(tempCourse);
			System.out.println("Done");
		}
		private void updateInstructor(AppDAO appDAO) {
			int theId = 1;
			
			System.out.println("Findiing the intructor id:"+theId);
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			
			//update the data
			System.out.println("Updating instructor id:"+theId);
			tempInstructor.setLastName("Uchiha");
			
			appDAO.update(tempInstructor);
			System.out.println("Done");
		}
		
		
		private void findInstructorWithCoursesByJoinFetch(AppDAO appDAO) {
			int theId= 1;
			//find instructor
			System.out.println("finding Instructor id:"+theId);
			Instructor tempInstructor =appDAO.findInstructorByJoinfetch(theId);
			
			
			System.out.println("tempinstructor "+tempInstructor);
			System.out.println("associated courses "+ tempInstructor.getCourses());
			System.out.println("Done");
			
		}
		
		
		private void findCoursesForInstructor(AppDAO appDAO) {
			int theId = 1;
			System.out.println("Finding instructor id :" + theId);
			
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			
			System.out.println("tempinstructor "+tempInstructor);
			
			System.out.println("Finding courses for instructor id :"+theId);
			
			List<Course> courses = appDAO.findCoursesByInstructorId(theId);
			
			tempInstructor.setCourses(courses);
			
			System.out.println("the associated courses :"+tempInstructor.getCourses());
			System.out.println("done!");
			
		}
		
		
		private void findInstructorWithCourses(AppDAO appDAO) {
			int theId = 1;
			System.out.println("Finding instructor id :" + theId);
			
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			
			System.out.println("tempinstructor "+tempInstructor);
			System.out.println("associated courses "+ tempInstructor.getCourses());
			System.out.println("Done");
		
		}
		
		
		private void creatInstructorWithCourses(AppDAO appDAO) {
			Instructor tempInstructor1 = new Instructor("Kakshi","Hatake","kakshi@leafvillage.com");
			//create the instructorDetails 
			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.youtube.com",	"Copy Ninja Technique");
			
			tempInstructor1.setInstructorDetail(tempInstructorDetails);
			
			Course tempCourse = new Course("abc");
			Course tempCourse1 = new Course("xyz");
			Course tempCourse2 = new Course("std");
			
			//add courses to instructor
			tempInstructor1.add(tempCourse);
			tempInstructor1.add(tempCourse1);
			tempInstructor1.add(tempCourse2);
			
			//save instructor
			System.out.println("saving instrcutor "+tempInstructor1 );
			System.out.println("courses :"+tempInstructor1.getCourses());
			
			appDAO.save(tempInstructor1);
			
			System.out.println("done!");
		}
		
		
		private void deleteInstructorDetails(AppDAO appDAO) {
			
			int theId = 4;
			appDAO.deleteInstructorDetailsById(theId);
		}
		private void findInstructorDetails(AppDAO appDAO) {
			
			int theId = 1;
			
			InstructorDetails tempInstructorDetails =    appDAO.finfInstructorDetailsById(theId);
			
		System.out.println("tempInstructorDetails "+tempInstructorDetails);
		
		System.out.println("associated : "+tempInstructorDetails.getInstructor());
			
		
		}
		
		
		private void deleteInstructor(AppDAO appDAO) {
			System.out.println("deleting the id ");
			int theId = 1;
			appDAO.deleteInstructorById(theId);
			
		}
		
		
		private void findInstructor(AppDAO appDAO) {
			
			System.out.println("3 in findIntructor method");
			int theId= 1;
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			
			System.out.println("Instructor :" +tempInstructor);
			System.out.println("associated instructor details "+ tempInstructor.getInstructorDetail());
			
		}
		
		
		private void createInstructor(AppDAO appDAO) {
			//create the instructor
			
			Instructor tempInstructor = new Instructor("Naruto","Uzumaki","naruto@leafvillage.com");
			System.out.println("in create method");
			Instructor tempInstructor1 = new Instructor("Sasuke","Uchiha","sauske@leafvillage.com");
			//create the instructorDetails 
			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.leafvillage.com/youtube",	"Ninja Training");
			InstructorDetails tempInstructorDetails1 = new InstructorDetails("http://www.leafvillage.com/youtube",
					"Chidori Training");
			//associate one to one relationship
			tempInstructor.setInstructorDetail(tempInstructorDetails);
			tempInstructor1.setInstructorDetail(tempInstructorDetails1);
			
			appDAO.save(tempInstructor);
			appDAO.save(tempInstructor1);
			
			
			
		}
}


