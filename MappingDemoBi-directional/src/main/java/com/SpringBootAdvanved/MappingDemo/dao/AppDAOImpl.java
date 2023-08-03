package com.SpringBootAdvanved.MappingDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootAdvanved.MappingDemo.entity.Instructor;
import com.SpringBootAdvanved.MappingDemo.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
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
		
		//retrieve the isntructor 
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
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


	
}
