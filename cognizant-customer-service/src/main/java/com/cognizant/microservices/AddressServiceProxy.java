package com.cognizant.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.microservices.domain.Address;

@FeignClient(name="cognizant-zuul-api-gateway")
@RibbonClient(name="cognizant-address-service")
public interface AddressServiceProxy {

	@PostMapping("cognizant-address-service/address/create")
	public Address createAddress(@RequestBody Address address);
	
	@PutMapping("cognizant-address-service/address/update")
	public Address updateAddress(@RequestBody Address address);	

	@GetMapping("cognizant-address-service/address/get/address-by-id/{address-by-id}")
	public Address getAddressById(@PathVariable("address-by-id") Long addressId);
}
