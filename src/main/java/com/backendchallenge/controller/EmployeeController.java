package com.backendchallenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendchallenge.bean.EmployeeRequest;
import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.exception.BackendChallengeException;
import com.backendchallenge.handler.EmployeeHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "EMS",description = "Employee")
public class EmployeeController {
	@Autowired
	private EmployeeHandler employeeHandler;

	/**
	 * 
	 * @param employee
	 * @return
	 * @throws BackendChallengeException
	 */
	@ApiOperation(value = "API to add employee")
	@PostMapping(path = "/api/v1/employees", produces = "application/json")
	public ResponseEntity<WsResponse> saveEmployee(@Valid @RequestBody EmployeeRequest employee)
			throws BackendChallengeException {
		WsResponse wsResponse = employeeHandler.AddEmployee(employee);
		System.out.println(wsResponse);
		return new ResponseEntity<WsResponse>(wsResponse, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @return
	 * @throws BackendChallengeException
	 */
	@GetMapping(path = "/api/v1/employees")
	@ApiOperation(value = "API to get all employee")
	public ResponseEntity<WsResponse> getAllEmployee() throws BackendChallengeException {
		WsResponse wsResponse = employeeHandler.getAllEmployee();
		System.out.println(wsResponse);
		return new ResponseEntity<WsResponse>(wsResponse, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws BackendChallengeException
	 */
	@PutMapping("/api/v1/employees/{id}")
	@ApiOperation(value = "API to update employee status")
	public ResponseEntity<WsResponse> updateEmployeeStatus(@PathVariable(name = "id") long id,
			@RequestParam(name = "status") String status) throws BackendChallengeException {

		WsResponse response = employeeHandler.updateUser(id, status);

		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}
