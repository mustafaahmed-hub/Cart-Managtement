package com.sapient.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.model.CartItem;
import com.sapient.spring.model.Product;
import com.sapient.spring.repository.CartRepository;
import com.sapient.spring.repository.ICartItemRepository;
import com.sapient.spring.repository.ICartRepository;

@Service
public class CartService {
//	@Autowired
//	private CartRepository cartRepository;
	@Autowired
	private ICartRepository cartRepository;
	
	public void checkout() {
		
	}
	public void cancel() {
		
	}
	public List<CartItem> getCartItems() {
		return null;
	}
	@Transactional
	public void addToCart(Product product,Long cartId) {
		CartItem cartItem = new CartItem();
		cartItem.setItemName(product.getName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(1);
		cartItem.setId(product.getId());
//		cartRepository.save(cartItem);
//						cartRepository.
		
	}
	
	
}
