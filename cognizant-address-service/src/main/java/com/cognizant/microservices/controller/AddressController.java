package com.cognizant.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservices.domain.Address;
import com.cognizant.microservices.exceptions.InvalidDataException;
import com.cognizant.microservices.exceptions.ResourceNotFoundException;
import com.cognizant.microservices.services.AddressService;
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired 
	AddressService addressService; 

	@PostMapping("/create")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) throws InvalidDataException {
		return ResponseEntity.ok().body(addressService.saveAddress(address));
	}

	@GetMapping("/all") 
	public ResponseEntity<List<Address>> getAllCustomer() {
		return ResponseEntity.ok().body(addressService.listAllAddress());
	}
	
	@PutMapping("/update")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) throws InvalidDataException, ResourceNotFoundException {
		return ResponseEntity.ok().body(addressService.updateAddress(address));
	}
	
	@DeleteMapping("/delete/address/{address-id}")
	public ResponseEntity<Boolean> deleteAddress(@PathVariable("address-id") Long addressId) throws InvalidDataException {
		return ResponseEntity.ok().body(addressService.deleteAddressById(addressId));
	}
	
	@GetMapping("/get/address-by-id/{address-by-id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("address-by-id") Long addressId) throws InvalidDataException {
		return ResponseEntity.ok().body(addressService.getAddressById(addressId));
	}
}
