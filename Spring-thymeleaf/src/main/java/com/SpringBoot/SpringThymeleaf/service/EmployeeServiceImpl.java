package com.SpringBoot.SpringThymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.SpringThymeleaf.entity.Employee;
import com.SpringBoot.SpringThymeleaf.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	//
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
		
	}
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}
	
//	@Override
//	public Employee findById(int theId) {
//		
//		return employeeRepository.findById(theId);
//	}
	
	@Override
	public Employee save(Employee theEmployee) {
	
		return employeeRepository.save(theEmployee);
	}
	
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
		
	}
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

}
