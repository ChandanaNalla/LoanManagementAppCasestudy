package com.casestudy.loanapp.search.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanManagementAppSearchMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementAppSearchMicroServiceApplication.class, args);
	}

}
