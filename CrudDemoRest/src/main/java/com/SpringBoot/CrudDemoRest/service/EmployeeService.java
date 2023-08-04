package com.SpringBoot.CrudDemoRest.service;

import java.util.List;

import com.SpringBoot.CrudDemoRest.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
