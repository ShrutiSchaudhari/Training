package com.SpringBoot.CrudDemoRest.restController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.CrudDemoRest.dao.EmployeeDao;
import com.SpringBoot.CrudDemoRest.entity.Employee;
import com.SpringBoot.CrudDemoRest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	//inject employee dao
	public EmployeeRestController(EmployeeService theEmployeeService) {
		
		employeeService = theEmployeeService;
	}
	//expose end points "/employees" and return a list of employee

	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("EMployee id not found: "+employeeId);
		}
		return theEmployee;
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		
		theEmployee.setId(0);
		//setting to zero is to save new employee and not update
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		
		Employee tempEmployee = employeeService.findById(employeeId);
				
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found: "+employeeId);
			
		}
		employeeService.deleteById(employeeId);
		return "Deleted Employee id:" + employeeId;
		 
		
	}

}
