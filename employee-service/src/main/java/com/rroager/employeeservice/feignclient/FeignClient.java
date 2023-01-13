package com.rroager.employeeservice.feignclient;

import com.rroager.employeeservice.response.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Getting URL (ADDRESS-SERVICE) to AddressService from the Eureka Discovery Server when not using API Gateway
// @FeignClient(value = "ADDRESS-SERVICE", path = "/api/address")

// Using Api Gateway to request from other microservices
@org.springframework.cloud.openfeign.FeignClient(value = "api-gateway")
public interface FeignClient {

    // Referring to the getById method in AddressServices AddressController, which makes up able to call it from the EmployeeService
    // address-service in the URL refers to the microservices name in the Eureka Discovery Server
    @GetMapping("address-service/api/address/getById/{id}")
    public AddressResponse getById(@PathVariable long id);

}
