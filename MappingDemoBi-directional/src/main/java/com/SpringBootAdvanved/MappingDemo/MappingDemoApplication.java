package com.SpringBootAdvanved.MappingDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SpringBootAdvanved.MappingDemo.dao.AppDAO;
import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;

@SpringBootApplication
public class MappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingDemoApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(AppDAO appDAO) {
			return runner->{
			//createInstructor(appDAO);
			//System.out.println("1 in main method ");	
			//findInstructor(appDAO);
			//System.out.println("2 method called ");
//			deleteInstructor(appDAO);
			//findInstructorDetails(appDAO);
			deleteInstructorDetails(appDAO);
			
		};
	
	
	
	
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
			int theId = 3;
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


