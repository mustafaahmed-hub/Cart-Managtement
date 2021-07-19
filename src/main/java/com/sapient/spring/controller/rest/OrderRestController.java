package com.sapient.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.spring.service.OrderService;


@RestController
public class OrderRestController {
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/ordera/checkout/{id}")
	public ResponseEntity checkout(@PathVariable Long cart_id) {
		orderService.checkout(cart_id);
		return new ResponseEntity("Cart checkout and order placed",HttpStatus.OK);
	}

}
