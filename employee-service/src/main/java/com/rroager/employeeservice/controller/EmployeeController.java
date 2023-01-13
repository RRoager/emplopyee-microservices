package com.rroager.employeeservice.controller;

import com.rroager.employeeservice.request.CreateEmployeeRequest;
import com.rroager.employeeservice.response.EmployeeResponse;
import com.rroager.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/create")
	public EmployeeResponse createEmployee (@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return employeeService.createEmployee(createEmployeeRequest);
	}
	
	@GetMapping("getById/{id}")
	public EmployeeResponse getById (@PathVariable long id) {
		return employeeService.getById(id);
	}
	
}
