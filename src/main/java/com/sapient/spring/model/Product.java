package com.sapient.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int quantiy;
	private Double price;
	private int category;
	
	
}
