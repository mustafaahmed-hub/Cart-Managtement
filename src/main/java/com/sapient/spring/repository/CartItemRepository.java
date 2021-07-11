package com.sapient.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.spring.model.CartItem;

//@Repository
public class CartItemRepository {
	List<CartItem> cartItems = new ArrayList();
	
	
	public List<CartItem> fetchAllCartItems() {
		return this.cartItems;
	}
	public  void addCartItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
		
	}

}
