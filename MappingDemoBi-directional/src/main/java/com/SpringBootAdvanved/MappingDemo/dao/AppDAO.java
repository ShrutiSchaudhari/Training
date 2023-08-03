package com.SpringBootAdvanved.MappingDemo.dao;

import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;

public interface AppDAO {

	void save(Instructor theInstructor);
	

	Instructor findInstructorById (int theId);
	
	void deleteInstructorById (int theId);
	
	InstructorDetails  finfInstructorDetailsById(int theId);
	
	void deleteInstructorDetailsById (int theId);
	
}
