package com.SpringSecurity.RestApiSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.RestApiSecurity.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
