package com.sapient.spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.exceptions.CartNotFoundException;
import com.sapient.spring.model.Cart;
import com.sapient.spring.model.CartItem;
import com.sapient.spring.model.Orders;
import com.sapient.spring.model.Product;
import com.sapient.spring.repository.CartRepository;
import com.sapient.spring.repository.ICartItemRepository;
import com.sapient.spring.repository.ICartRepository;
import com.sapient.spring.repository.IOrderRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CartService {
	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	CartItem cartItem;
	@Autowired
	private ICartItemRepository cartItemRepository; 
	@Autowired
	private OrderService orderService;
	
	private Double totalValue;
	
	
	public void cancel() {
		
	}
	public List<CartItem> getCartItems(Long id) {
		List<CartItem> cartItems = cartRepository.findById(id).get().getCartItemList();
		return cartItems;
	}
	public Cart getCartById(Long cart_id) {
		Optional<Cart> cart = cartRepository.findById(cart_id);
		if(cart.isEmpty())
			throw new CartNotFoundException("Cart with id not found:{id}");
		
			return cart.get();
		
		
	}
	
	@Transactional
	public  void addToCart(Product product, Long cart_id) {
//		CartItem cartItem = CartItem();
		cartItem.setItemName(product.getName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(1);
		cartItem.setId(product.getId());
		log.info("Cart Item added is :{}",cartItem);
//		
//		iCartItemRepository.save(cartItem);
		Cart cart  = getCartById(cart_id);
		if(cart!=null) {
			cartItem.setCart(cart);
			cartItemRepository.save(cartItem);
		
		
			}
		else {
			log.info("no cart of this id");
		}
	}
	public void initializeCart(Cart cart) {
		
		cartRepository.save(cart);
		
	}
	public List<Cart> showAllCarts() {
		
		List<Cart> carts = (List<Cart>) cartRepository.findAll();
		return carts;
	}
//	public void increaseItemQuantity(Long id, Long itemId) {
//		Cart cart=cartRepository.findById(id).get();
//		
//		
//	}
	public void findTotalValue(Long id) {
		Optional<Cart> cart = cartRepository.findById(id);
		if(cart.isEmpty())
			throw new CartNotFoundException("Cart not found id :{id}");
		Cart obj = cart.get();
		List<CartItem> cartItems = obj.getCartItemList();
		totalValue =0.0;
		for(CartItem cartItem:cartItems)
			totalValue+= cartItem.getQuantity()*cartItem.getPrice();
		obj.setTotalValue(totalValue);
		
		cartRepository.save(obj);
	
		
		
		
		
	}
	
	
	
}
