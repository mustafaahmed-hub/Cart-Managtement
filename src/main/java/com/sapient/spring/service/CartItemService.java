package com.sapient.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.exceptions.CartItemNotFoundException;
import com.sapient.spring.model.CartItem;
import com.sapient.spring.model.Product;
import com.sapient.spring.repository.CartItemRepository;
import com.sapient.spring.repository.CartRepository;
import com.sapient.spring.repository.ICartItemRepository;


@Service
public class CartItemService {
	

	@Autowired
	private ICartItemRepository iCartItemRepository;
	@Autowired
	private CartService cartService;
	
	public void increaseQuantity(Long id) {
		Optional<CartItem> cartItem = iCartItemRepository.findById(id);
		if(cartItem.isPresent()) {
			CartItem item = cartItem.get();
			item.setQuantity(item.getQuantity()+1);
			iCartItemRepository.save(item);
		}
		else
			throw new CartItemNotFoundException("Cart item not found with id :"+id);
	
	}
	public void decreaseQuantity(Long id) {
		Optional<CartItem> cartItem = iCartItemRepository.findById(id);
		if(cartItem.isPresent()) {
			CartItem item = cartItem.get();
			item.setQuantity(item.getQuantity()-1);
			iCartItemRepository.save(item);
		}
		else
			throw new CartItemNotFoundException("Cart item not found with id :"+id);
	}
	public void removeFromCart() {
		
	}
	

}
