package com.backendchallenge.service;

import java.util.List;

import com.backendchallenge.model.Employee;
/**
 * 
 * @author lapto
 *
 */
public interface EmployeeService {
	
	 public List<Employee> retrieveEmployees();
	  
	 public Employee getEmployee(Long employeeId);
	  
	 public Employee saveEmployee(Employee employee);
	  
	 public void deleteEmployee(Long employeeId);
	  
	 public Employee updateEmployee(Employee employee);

}
