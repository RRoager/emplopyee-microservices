package com.rroager.addressservice.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAddressRequest {
	private String street;

	private String city;

}
