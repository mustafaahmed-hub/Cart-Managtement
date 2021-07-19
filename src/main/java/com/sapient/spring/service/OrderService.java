package com.sapient.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.exceptions.CartNotFoundException;
import com.sapient.spring.model.Cart;
import com.sapient.spring.model.Orders;
import com.sapient.spring.repository.ICartRepository;
import com.sapient.spring.repository.IOrderRepository;
import com.sapient.spring.validator.Validate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	private CartService cartService;
	@Autowired
	private Validate validate;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private IOrderRepository orderRepository;
	
	private Double totalValue;
	
	public void checkout(Long cart_id) {
		Optional<Cart> cart = cartRepository.findById(cart_id);
		if(cart.isEmpty())
			throw new CartNotFoundException("Cart not found with id :{cart_id}");
		Cart obj = cart.get();
		totalValue = obj.getTotalValue();
		Orders order = new Orders();
		order.setCustomer_id(obj.getCustomerId());
		order.setTotalValue(totalValue);
		
		
		if(validate.isOrderValid(order.getId())) {
			if(paymentService.isPaymentSuccessful(order.getId())) {
				cartRepository.delete(obj);
				orderRepository.save(order);
				log.info("order with order id :{} is place ", order.getId());
			}
			
		}
		
		
		
		
		
	}

}
