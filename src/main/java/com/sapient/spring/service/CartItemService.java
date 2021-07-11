package com.sapient.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.model.CartItem;
import com.sapient.spring.repository.CartItemRepository;
import com.sapient.spring.repository.CartRepository;
import com.sapient.spring.repository.ICartItemRepository;

@Service
public class CartItemService {
	
//	@Autowired
//	private CartItemRepository cartItemRepository;
	@Autowired
	private CartItem cartItem;
	@Autowired
	private ICartItemRepository iCartItemRepository;
	
	public void increaseQuantity() {
		this.cartItem.setQuantity(cartItem.getQuantity()+1);
	}
	public void decreaseQuantity() {
		this.cartItem.setQuantity(cartItem.getQuantity()-1);
	}
	public void removeFromCart() {
		
	}
	public  void addToCart(CartItem cartItem) {
		iCartItemRepository.save(cartItem);
		
	}

}
