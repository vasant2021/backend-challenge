package com.backendchallenge.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.backendchallenge.bean.EmployeeRequest;
import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.constants.ResponseMessage;
import com.backendchallenge.enums.EmployeeStatusEnum;
import com.backendchallenge.enums.ErrorMessageEnum;
import com.backendchallenge.exception.BackendChallengeException;
import com.backendchallenge.model.Employee;
import com.backendchallenge.service.EmployeeService;
/**
 * 
 * @author lapto
 *
 */
@Component
public class EmployeeHandlerImpl implements EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Method is used to create new employee
	 */
	@Override
	public WsResponse AddEmployee(EmployeeRequest employee) throws BackendChallengeException {
		final WsResponse response = new WsResponse();
		Employee empsave = new Employee();
		empsave.setName(employee.getName());
		empsave.setSalary(employee.getSalary());
		empsave.setDepartment(employee.getDepartment());
		empsave.setStatus(EmployeeStatusEnum.ADDED);
		empsave.setAge(employee.getAge());
		empsave.setBirthdate(employee.getBirthdate());
		empsave.setCity(employee.getCity());
		empsave.setCompany_name(employee.getCompany_name());
		empsave.setJob_title(employee.getJob_title());
		empsave.setPhoneNumber(employee.getPhoneNumber());
		empsave.setState(employee.getState());
		empsave = employeeService.saveEmployee(empsave);
		if (empsave == null) {
			throw new BackendChallengeException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
		}
		response.setMessage(ResponseMessage.SUCCESS);
		response.setStatus((empsave == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
		response.setData(empsave);
		return response;

	}

	/**
	 * Method is used to get all employee
	 */
	@Override
	public WsResponse getAllEmployee() throws BackendChallengeException {
		final WsResponse response = new WsResponse();
		final List<Employee> employee = employeeService.retrieveEmployees();
		response.setData(employee);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage(ResponseMessage.SUCCESS);
		return response;
	}

	/**
	 * Method is used to update employee status
	 */
	@Override
	public WsResponse updateUser(long id, String status) throws BackendChallengeException {
		final WsResponse response = new WsResponse();
		Employee findEmp = employeeService.getEmployee(id);
		if (findEmp == null) {
			throw new BackendChallengeException(ErrorMessageEnum.APP003.name(), ErrorMessageEnum.APP003.value());
		}
		if (!EmployeeStatusEnum.isType(status)) {
			throw new BackendChallengeException(ErrorMessageEnum.APP004.name(), ErrorMessageEnum.APP004.value());
		}
		findEmp.setStatus(EmployeeStatusEnum.getType(status));
		findEmp = employeeService.updateEmployee(findEmp);
		response.setStatus((findEmp == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
		response.setData(findEmp);
		response.setMessage(ResponseMessage.UPDATED);
		return response;
	}

}
