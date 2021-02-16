package com.backendchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendchallenge.model.Employee;
 
 /**
  * 
  * @author lapto
  *
  */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}
