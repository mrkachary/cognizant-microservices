package com.cognizant.microservices.services;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microservices.domain.Customer;
import com.cognizant.microservices.exception.ResourceNotFoundException;
import com.cognizant.microservices.helper.CustomerMapper;
import com.cognizant.microservices.model.CustomerDTO;
import com.cognizant.microservices.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerService {

	@Autowired
	CustomerMapper customerMapper;

	@Autowired
	CustomerRepository customerRepository;

	/**
	 * creating customer details and his address
	 * 
	 * @param customer
	 * @return
	 */
	public Customer createCustomer(Customer customer) {
		Date currentDate = new Date();
		Timestamp currentTimestamp = new Timestamp(currentDate.getTime());

		customer.setCreatedDate(currentTimestamp);
		customer.setUpdatedDate(currentTimestamp);

		log.info("Started creating customer");
		CustomerDTO toModel = customerMapper.mapCustomerDomainToModel(customer);
		customer = customerMapper.mapCustomerModelToDomain(customerRepository.save(toModel));		
		log.info("Successfully created a customer with customer id :"+customer.getCustId());
		return customer;
	}

	/**
	 * Listing all Customer details
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomer() {

		Iterable<CustomerDTO> procuredCustomers = customerRepository.findAll();
		List<Customer> customers = new ArrayList<Customer>();

		for(CustomerDTO procuredCustomer : procuredCustomers) {
			Customer customer = customerMapper.mapCustomerModelToDomain(procuredCustomer);
			customers.add(customer);
		}
		return customers;
	}

	/**
	 * Listing all customers by their first or last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Customer> getAllCustomerByName(String firstName, String lastName) {
		List<CustomerDTO> procuredCustomers = customerRepository.findByFirstNameOrLastName(firstName, lastName);
		List<Customer> customers = new ArrayList<Customer>();

		for(CustomerDTO procuredCustomer : procuredCustomers) {
			Customer customer = customerMapper.mapCustomerModelToDomain(procuredCustomer);
			customers.add(customer);
		}
		return customers;
	}

	/**
	 * Get customer by customer id
	 * 
	 * @param custId
	 * @return
	 */
	public Customer getCustomerById(long custId) {
		Optional<CustomerDTO> toModel = customerRepository.findById(custId);
		if(toModel.isPresent()) 
			return customerMapper.mapCustomerModelToDomain(toModel.get());
		else
			return null;
	}

	/**
	 * update customer details
	 * @param customer 
	 * 
	 * @param custId
	 * @return
	 * @throws ResourceNotFoundException 
	 */

	public Customer updateLivingAddress(Customer customer) throws ResourceNotFoundException {
		Optional<CustomerDTO> toModel = customerRepository.findById(customer.getCustId());
		Date currentDate = new Date();
		Timestamp currentTimestamp = new Timestamp(currentDate.getTime());
		if(toModel.isPresent()) {
			CustomerDTO updatedCustomer= customerMapper.mapAddressToCustomer(toModel.get(), customer);

			updatedCustomer.setUpdatedDate(currentTimestamp);
			log.info("Updating customer living address");
			CustomerDTO savedCustomer = customerRepository.save(updatedCustomer);
			log.info("Successfully updating customer living address");
			return customerMapper.mapCustomerModelToDomain(savedCustomer);
		} else {
			log.error("Cannot update customer address");
			throw new ResourceNotFoundException("could not update customer with id "+customer.getCustId());
		}		
	}
}
