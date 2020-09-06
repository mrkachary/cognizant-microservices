package com.cognizant.microservices.services;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microservices.domain.Address;
import com.cognizant.microservices.exceptions.ResourceNotFoundException;
import com.cognizant.microservices.helper.AddressMapper;
import com.cognizant.microservices.model.AddressDTO;
import com.cognizant.microservices.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	AddressMapper addressMapper;

	public List<Address> listAllAddress() {
		List<Address> resultAddressList = new ArrayList<Address>(); 
		Iterable<AddressDTO> addressListDTOs = addressRepository.findAll();
		if(addressListDTOs!=null) {
			for(AddressDTO address:addressListDTOs) {
				resultAddressList.add(addressMapper.mapModelToDomain(address));
			}	
		}		
		return resultAddressList;
	}

	public Address getAddressById(long addressId) {
		Address result = null;
		Optional<AddressDTO> address = addressRepository.findById(addressId);
		if(address.isPresent()) {
			result = addressMapper.mapModelToDomain(address.get());
		}
		return result;
	}
	
	public boolean deleteAddressById(long addressId) {
		Optional<AddressDTO> address = addressRepository.findById(addressId);
		if(address.isPresent()) {
			addressRepository.delete(address.get());
		}
		return true;
	}

	public Address saveAddress(Address address) {
		AddressDTO addressDTO = addressMapper.mapDomainToModel(address);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		addressDTO.setCreatedDate(timestamp);
		addressDTO.setUpdatedDate(timestamp);
		AddressDTO savedDTO = addressRepository.save(addressDTO);
		Address savedAddress = addressMapper.mapModelToDomain(savedDTO);

		return savedAddress;
	}

	public Address updateAddress(Address address) throws ResourceNotFoundException {
		Address savedAddress = null;
		
		Optional<AddressDTO> existingAddress = addressRepository.findById(address.getCustAddressId());
		
		if(existingAddress.isPresent()) {
			AddressDTO persistedAddress = existingAddress.get();
			persistedAddress.setDoorNo(address.getDoorNo());
			persistedAddress.setStreet(address.getStreet());
			persistedAddress.setCity(address.getCity());
			persistedAddress.setCountry(address.getCountry());
			persistedAddress.setZipCode(address.getZipCode());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			persistedAddress.setUpdatedDate(timestamp);
			AddressDTO savedDTO = addressRepository.save(persistedAddress);
			savedAddress = addressMapper.mapModelToDomain(savedDTO);

		} else {
			throw new ResourceNotFoundException("Address with Address ID" +address.getCustAddressId()+" does not exists");
		}
		return savedAddress;
	}
}
