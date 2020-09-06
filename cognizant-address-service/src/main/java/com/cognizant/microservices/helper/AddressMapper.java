package com.cognizant.microservices.helper;

import org.springframework.stereotype.Component;

import com.cognizant.microservices.domain.Address;
import com.cognizant.microservices.model.AddressDTO;

@Component
public class AddressMapper {

	public AddressDTO mapDomainToModel(Address address) {

		AddressDTO mappedAddress = new AddressDTO();

		mappedAddress.setCustAddressId(address.getCustAddressId());
		mappedAddress.setDoorNo(address.getDoorNo());
		mappedAddress.setStreet(address.getStreet());
		mappedAddress.setCity(address.getCity());
		mappedAddress.setCountry(address.getCountry());
		mappedAddress.setZipCode(address.getZipCode());

		return mappedAddress;
	}

	public Address mapModelToDomain(AddressDTO address) {

		Address mappedAddress = new Address();

		mappedAddress.setCustAddressId(address.getCustAddressId());
		mappedAddress.setDoorNo(address.getDoorNo());
		mappedAddress.setStreet(address.getStreet());
		mappedAddress.setCity(address.getCity());
		mappedAddress.setCountry(address.getCountry());
		mappedAddress.setZipCode(address.getZipCode());
		mappedAddress.setCreatedDate(address.getCreatedDate());
		mappedAddress.setUpdatedDate(address.getUpdatedDate());

		return mappedAddress;
	}
}
