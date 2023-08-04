package com.SpringBoot.CrudDemoRest.dao;

import java.util.List;

import com.SpringBoot.CrudDemoRest.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
	
 }
