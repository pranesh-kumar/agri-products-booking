package com.krishna.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.model.Department;
import com.krishna.demo.model.Employee;
import com.krishna.demo.repository.DepartmentRepo;
import com.krishna.demo.repository.EmployeeRepo;
import com.krishna.demo.request.EmployeeRequest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	DepartmentRepo dRepository;
	@Autowired
	EmployeeRepo eRepository;

	@Operation(summary = "Creates a new employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "employee created successfully"),
			@ApiResponse(responseCode = "400", description = "employee is invalid"),
			@ApiResponse(responseCode = "401", description = "invalid credentials") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/employee", produces = "application/json", consumes = "application/json")
	public Employee saveEmployee(@RequestBody EmployeeRequest eRequest) {
		Department department = new Department();
		department.setName(eRequest.getDepartment());
		department = dRepository.save(department);
		Employee employee = new Employee(eRequest);
		employee.setDepartment(department);
		eRepository.save(employee);
		return employee;
	}

	@Operation(summary = "Get all the employees")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "getting employee successfully"),
			@ApiResponse(responseCode = "401", description = "invalid credentials"),
			@ApiResponse(responseCode = "404", description = "employee not found") })
	@GetMapping(value = "/employee", produces = "application/json")
	public List<Employee> getEmployees() {
		return eRepository.findAll();
	}

	@GetMapping("/department")
	public List<Department> getDepartment() {
		return dRepository.findAll();
	}
}
//http://localhost:8080/swagger-ui/index.html