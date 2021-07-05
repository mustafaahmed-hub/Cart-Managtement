package com.sapient.spring.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private List<CartItem> itemList;
	private Double totalValue;
	private long id;
	
	public void checkout() {
		
	}
	public void cancel() {
		
	}
	
}
