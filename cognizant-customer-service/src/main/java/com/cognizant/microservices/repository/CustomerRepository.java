package com.cognizant.microservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.microservices.model.CustomerDTO;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDTO, Long>{

	List<CustomerDTO> findByFirstNameOrLastName(String firstName, String lastName);

}
