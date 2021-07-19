package com.sapient.spring.exceptions;

public class CartNotFoundException extends RuntimeException {
	public CartNotFoundException(String msg) {
		super(msg);
		}
}
