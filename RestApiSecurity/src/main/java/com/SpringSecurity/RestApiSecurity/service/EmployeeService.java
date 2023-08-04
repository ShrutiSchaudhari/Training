package com.SpringSecurity.RestApiSecurity.service;

import java.util.List;

import com.SpringSecurity.RestApiSecurity.entity.Employee;

public interface EmployeeService {
	
	 List<Employee> findAll();

	    Employee findById(int theId);

	    Employee save(Employee theEmployee);

	    void deleteById(int theId);
}
