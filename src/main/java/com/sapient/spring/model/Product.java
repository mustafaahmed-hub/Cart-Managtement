package com.sapient.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String name;
	private long id;
	private int quantiy;
	private Double price;
	private int category;
	
	
}
