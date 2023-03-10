package com.rroager.addressservice.response;

import com.rroager.addressservice.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
	private long addressId;

	private String street;

	private String city;

	public AddressResponse(Address address) {
		this.addressId = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
	}
}
