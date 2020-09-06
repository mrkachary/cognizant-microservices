package com.cognizant.microservices.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="CUSTOMER")
@Table
@Data
public class CustomerDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="CUST_ID")
	private long custId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="AGE")
	private int age;

	@Column(name="CUST_ADDRS_ID") 
	private long custAddressId;
	 
	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="UPDATED_DATE")
	private Timestamp updatedDate;
	

}

