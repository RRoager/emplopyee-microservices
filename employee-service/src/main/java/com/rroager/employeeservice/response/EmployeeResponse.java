package com.rroager.employeeservice.response;

import com.rroager.employeeservice.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	private AddressResponse addressResponse;

	public EmployeeResponse(Employee employee) {
		this.id = employee.getId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
	}
}
