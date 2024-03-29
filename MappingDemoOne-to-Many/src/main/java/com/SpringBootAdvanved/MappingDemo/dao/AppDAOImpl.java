package com.SpringBootAdvanved.MappingDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootAdvanved.MappingDemo.entity.Course;
import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

	// define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		
		this.entityManager= entityManager;
	}
	
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
		
		
		
	}

	
	@Override
	public Instructor findInstructorById(int theId) {
		System.out.println("in DAOimpl");
		return entityManager.find(Instructor.class, theId)
				;
	}


	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		
		//retrieve the instructor 
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		//get the courses
		List<Course> courses = tempInstructor.getCourses();
				//break association link
				for(Course tempCourse : courses) {
					tempCourse.setInstructor(null);
				}
		entityManager.remove(tempInstructor);
		
	}


	@Override
	public InstructorDetails finfInstructorDetailsById(int theId) {
		
		return entityManager.find(InstructorDetails.class, theId);
		}


	@Override
	@Transactional
	public void deleteInstructorDetailsById(int theId) {
		
		//retrieve details
		InstructorDetails temoInstructorDetails = entityManager.find(InstructorDetails.class, theId);
		
		// remove the object reference AND BI-DIRECTIONAL link
		
		temoInstructorDetails.getInstructor().setInstructorDetail(null);
		 entityManager.remove(temoInstructorDetails);
		
	}


	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		//create query 
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class );
		query.setParameter("data", theId);
		
		List<Course> courses = query.getResultList();
		
		return courses;
	}


	@Override
	public Instructor findInstructorByJoinfetch(int theId) {
		//create the query 
		TypedQuery<Instructor> query = entityManager.createQuery(
				"select i from Instructor i "+ 
				"JOIN FETCH i.courses "+
				"JOIN FETCH i.instructorDetail "+
				"where i.id =:data "
				
						, Instructor.class);
		query.setParameter("data", theId);
		Instructor instructor = query.getSingleResult();
		return instructor;
	}


	@Override
	@Transactional
	public void update(Instructor theInstructor) {
		
		entityManager.merge(theInstructor);
		
		
	}


	@Override
	@Transactional
	public void update(Course tempCourse) {
		
		entityManager.merge(tempCourse);
	}


	@Override
	public Course findCourseById(int theId) {
		
		return entityManager.find(Course.class, theId);
	}


	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		
		//RETRIEVE THE COURSE
		Course tempCourse = entityManager.find(Course.class, theId);
		
		entityManager.remove(tempCourse);
	}


	@Override
	@Transactional
	public void save(Course theCourse) {
		 entityManager.persist(theCourse);
		
	}


	
}
