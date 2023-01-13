package com.rroager.employeeservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rroager.employeeservice.entity.Employee;
import com.rroager.employeeservice.feignclient.FeignClient;
import com.rroager.employeeservice.repository.EmployeeRepository;
import com.rroager.employeeservice.request.CreateEmployeeRequest;
import com.rroager.employeeservice.response.AddressResponse;
import com.rroager.employeeservice.response.EmployeeResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	private final EmployeeRepository employeeRepository;
	private final CommonService commonService;
	// Used before the creation of CommonServices
	//private final FeignClient feignClient;
	// Only used when communicating between services with WebClient
	//private final WebClient webClient;

	public EmployeeService(EmployeeRepository employeeRepository, CommonService commonService) {
		this.employeeRepository = employeeRepository;
		this.commonService = commonService;
	}

	public EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

		Employee employee = new Employee();
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setEmail(createEmployeeRequest.getEmail());

		employee.setAddressId(createEmployeeRequest.getAddressId());
		employee = employeeRepository.save(employee);

		return getEmployeeResponse(employee);
	}
	
	public EmployeeResponse getById (long id) {
		logger.info("Inside EmployeeService getByID() method");

		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee != null) {
			return getEmployeeResponse(employee);
		}
		return null;
	}

	public EmployeeResponse getEmployeeResponse(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse(employee);

		// Getting and setting address via WebClient based on employees address ID
		//employeeResponse.setAddressResponse(getAddressById(employee.getAddressId()));

		// Getting and setting address via OpenFeign based on employees address ID
		//employeeResponse.setAddressResponse(feignClient.getById(employee.getAddressId()));

		// Used before the creation of CommonService
		//employeeResponse.setAddressResponse(getAddressById(employee.getAddressId()));

		employeeResponse.setAddressResponse(commonService.getAddressById(employee.getAddressId()));

		return employeeResponse;
	}

	// Used before the creation of CommonService
	/*
	// Applying Circuit Breaker for the communication between the Employee and Address microservice
	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById (long addressId) {
		return feignClient.getById(addressId);
	}

	// Circuit Breaker Fallback method if getAddressById method fails
	public AddressResponse fallbackGetAddressById (long addressId, Throwable throwable) {
		logger.error("Error = " + throwable);
		return new AddressResponse();
	}
	*/


	// Used for the WebClient approach to communicate between microservices
	/*
	public AddressResponse getAddressById (long addressId) {
		Mono<AddressResponse> addressResponse =
				webClient.get().uri("/getById/" + addressId)
						.retrieve().bodyToMono(AddressResponse.class);

		return addressResponse.block();
	}
	*/
}
