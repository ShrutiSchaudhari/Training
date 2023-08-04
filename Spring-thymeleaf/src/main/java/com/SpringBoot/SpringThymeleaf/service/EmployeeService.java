package com.SpringBoot.SpringThymeleaf.service;

import java.util.List;

import com.SpringBoot.SpringThymeleaf.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
