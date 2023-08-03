package com.SpringBootAdvanved.MappingDemo.dao;

import java.util.List;

import com.SpringBootAdvanved.MappingDemo.entity.Course;
import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById (int theId);
	
	void deleteInstructorById (int theId);
	
	InstructorDetails  finfInstructorDetailsById(int theId);
	
	void deleteInstructorDetailsById (int theId);
	
	List<Course> findCoursesByInstructorId(int theId);
	
	Instructor findInstructorByJoinfetch(int theId);
	
	void update(Instructor theInstructor);
	
	void update(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course thecourse);
	
	
	
}
