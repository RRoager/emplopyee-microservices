package com.rroager.employeeservice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
	private String firstName;

	private String lastName;

	private String email;

	private long addressId;

}
