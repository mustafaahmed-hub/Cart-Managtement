package com.sapient.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.repository.CustomerRepository;
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

}
