package com.sapient.spring.exceptions;

public class CartItemNotFoundException extends RuntimeException {
	public CartItemNotFoundException(String msg) {
		super(msg);
	}

}
