package com.rroager.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	// Used for the WebClient approach to communicate between microservices
	/*
	@Value("${address.service.url}")
	private String addressServiceUrl;


	@Bean
	public WebClient webClient () {
		return WebClient.builder()
				.baseUrl(addressServiceUrl).build();
	}
	*/
}
