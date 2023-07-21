package com.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

	// define field for entity manager
	private EntityManager entityManager;
	
	// constructor
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	//IMPPLEMENT save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	//read
	@Override
	public Student findById(Integer id) {
		
		return entityManager.find(Student.class, id);
		}

	//query
	@Override
	public List<Student> findAll() {
		//create query 
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName desc",Student.class );
		//return query result
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastName(String theLastName) {
		//create query
		TypedQuery<Student> theQuery = entityManager.createQuery
				("From Student where lasttName= :theData",Student.class );
		//set query parameter
							//parameter , object passed in method
		theQuery.setParameter("theData", theLastName);
		
		//return query results
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		//retrieve the student 
		Student theStudent = entityManager.find(Student.class, id);
		
		//delete the student
		entityManager.remove(theStudent);
	}


	
}
