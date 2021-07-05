package com.sapient.spring.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CartItem {
	private String itemName;
	private long id;
	private int quantity;
	private Double price;

}
