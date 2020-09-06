package com.cognizant.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients("com.cognizant.microservices")
@EnableSwagger2
@EnableDiscoveryClient
public class CognizantCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CognizantCustomerServiceApplication.class, args);
	}

}
