package com.cognizant.microservices.helper;

import org.springframework.stereotype.Component;

import com.cognizant.microservices.domain.Address;
import com.cognizant.microservices.domain.Customer;
import com.cognizant.microservices.model.CustomerDTO;

@Component
public class CustomerMapper {

	public CustomerDTO mapCustomerDomainToModel(Customer customer) {

		CustomerDTO mappedCustomer = new CustomerDTO();
		if(customer!=null) {

			mappedCustomer.setCustId(customer.getCustId());
			mappedCustomer.setFirstName(customer.getFirstName());
			mappedCustomer.setLastName(customer.getLastName());
			mappedCustomer.setAge(customer.getAge());
			mappedCustomer.setCustAddressId(customer.getCustAddressId());
			mappedCustomer.setCreatedDate(customer.getCreatedDate());
			mappedCustomer.setUpdatedDate(customer.getUpdatedDate());
		}
		return mappedCustomer;
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Customer mapCustomerModelToDomain(CustomerDTO customer) {

		Customer mappedCustomer = new Customer();
		Address mappedAddress = new Address();
		
		if(customer!=null) {
			mappedCustomer.setCustId(customer.getCustId());
			mappedCustomer.setFirstName(customer.getFirstName());
			mappedCustomer.setLastName(customer.getLastName());
			mappedCustomer.setAge(customer.getAge());
			mappedCustomer.setCustAddressId(customer.getCustAddressId());
			mappedCustomer.setAddress(mappedAddress);
			mappedCustomer.setCreatedDate(customer.getCreatedDate());
			mappedCustomer.setUpdatedDate(customer.getUpdatedDate());
		}
		return mappedCustomer;
	}

	public CustomerDTO mapAddressToCustomer(CustomerDTO toModel,
			Customer customer) {
		toModel.setAge(customer.getAge());
		toModel.setFirstName(customer.getFirstName());
		toModel.setLastName(customer.getLastName());
		toModel.setCustAddressId(customer.getAddress().getCustAddressId());
		return toModel;
	}
}
