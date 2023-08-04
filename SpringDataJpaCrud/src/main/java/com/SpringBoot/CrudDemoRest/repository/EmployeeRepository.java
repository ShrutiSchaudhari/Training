package com.SpringBoot.CrudDemoRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemoRest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
