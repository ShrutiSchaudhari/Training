package com.SpringBoot.CrudDemoRest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBoot.CrudDemoRest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	//define field for entity manager
	private EntityManager entityManager;
	
	//set up CI
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		
		entityManager= theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		
		//execute query and get result
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get employee id 
		Employee theEmployee = entityManager.find(Employee.class, theId);
		// return employee
		
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
	// find employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//remove employee
		entityManager.remove(theEmployee);
		
	}

}
