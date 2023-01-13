package com.rroager.employeeservice.service;

import com.rroager.employeeservice.feignclient.FeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rroager.employeeservice.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	Logger logger = LoggerFactory.getLogger(CommonService.class);
	long callsCount = 1;
	private final FeignClient feignClient;

	public CommonService(FeignClient feignClient) {
		this.feignClient = feignClient;
	}

	// Applying Circuit Breaker for the communication between the Employee and Address microservice
	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById (long addressId) {
		logger.info("Number of calls = " + callsCount);
		callsCount++;

		return feignClient.getById(addressId);
	}

	// Circuit Breaker Fallback method if getAddressById method fails
	public AddressResponse fallbackGetAddressById (long addressId, Throwable throwable) {
		logger.error("Error = " + throwable);
		return new AddressResponse();
	}
	
}

