package com.rroager.addressservice.controller;

import com.rroager.addressservice.request.CreateAddressRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rroager.addressservice.response.AddressResponse;
import com.rroager.addressservice.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

    private final AddressService addressService;
    @Value("${address.test}")
    private String test;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id) {
        return addressService.getById(id);
    }

    @GetMapping("/test")
    public String test() {
        return test;
    }
	
}
