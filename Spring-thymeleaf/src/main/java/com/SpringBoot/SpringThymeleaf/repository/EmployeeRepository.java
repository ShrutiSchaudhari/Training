package com.SpringBoot.SpringThymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.SpringThymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
