package com.sapient.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sapient.spring.model.Product;
import com.sapient.spring.service.CartService;

public class CartRestController {
	@Autowired
	CartService cartService;
	
	@PostMapping("carts/{id}/addToCart")
    public ResponseEntity addToCart(@PathVariable(value = "id")Long id, @RequestBody Product product) {
    	
    	cartService.addToCart(product,id);
    	return new ResponseEntity("Product has been added in the cart",HttpStatus.CREATED);
    }

}
