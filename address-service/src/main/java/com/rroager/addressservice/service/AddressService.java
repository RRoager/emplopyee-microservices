package com.rroager.addressservice.service;

import com.rroager.addressservice.entity.Address;
import com.rroager.addressservice.repository.AddressRepository;
import com.rroager.addressservice.request.CreateAddressRequest;
import com.rroager.addressservice.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById (long id) {

        logger.info("Inside AddressService getById(" + id + ")");

        Address address = addressRepository.findById(id).orElse(null);

        if (address != null) {
            return new AddressResponse(address);
        }

        return null;
    }

}
