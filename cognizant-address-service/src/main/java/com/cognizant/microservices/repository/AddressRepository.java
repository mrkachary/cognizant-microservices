package com.cognizant.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.microservices.model.AddressDTO;

@Repository
public interface AddressRepository extends CrudRepository<AddressDTO, Long>{

}
