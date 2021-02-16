package com.backendchallenge.handler;

import com.backendchallenge.bean.EmployeeRequest;
import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.exception.BackendChallengeException;

public interface EmployeeHandler {

	WsResponse AddEmployee(EmployeeRequest employee) throws BackendChallengeException;
	WsResponse getAllEmployee() throws BackendChallengeException;
	WsResponse updateUser(long id, String status)throws BackendChallengeException;
	
}
