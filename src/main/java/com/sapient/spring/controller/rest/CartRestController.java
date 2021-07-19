package com.sapient.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.spring.model.Cart;
import com.sapient.spring.model.CartItem;
import com.sapient.spring.model.Product;
import com.sapient.spring.service.CartItemService;
import com.sapient.spring.service.CartService;
@RestController
public class CartRestController {
	@Autowired
	CartService cartService;
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/carts/{id}/addToCart")
    public ResponseEntity addToCart(@PathVariable Long id, @RequestBody Product product) {
    	
    	cartService.addToCart(product,id);
//		cartItemService.addToCart(product, id);
    	cartService.findTotalValue(id);
    	return new ResponseEntity("Product has been added in the cart",HttpStatus.CREATED);
    }
	@GetMapping("/carts/{id}")
	public ResponseEntity showCartItemsOfCart(@PathVariable Long id) {
		List<CartItem> cartItems = cartService.getCartItems(id);
		cartService.findTotalValue(id);
		return new ResponseEntity(cartItems,HttpStatus.OK); 
	}
	@PostMapping("/carts/{itemId}/increaseQuantity")
	public ResponseEntity increaseItemQuantity(@PathVariable Long itemId){
		cartItemService.increaseQuantity(itemId);
		return new ResponseEntity("Item quantity increased",HttpStatus.OK);
		
	}
	@PostMapping("/carts/{itemId}/decreaseQuantity")
	public ResponseEntity decreaseItemQuantity(@PathVariable Long itemId){
		cartItemService.decreaseQuantity(itemId);
		return new ResponseEntity("Item quantity decreased",HttpStatus.OK);
		
	}

	@PostMapping("/carts")
	public ResponseEntity initialilzeCart(@RequestBody Cart cart) {
		cartService.initializeCart(cart);
		return new ResponseEntity("New cart has been created",HttpStatus.CREATED);
		
	}
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> getAllCarts() {
		
			try {
				List<Cart> carts = cartService.showAllCarts();
				return new ResponseEntity(carts, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return new ResponseEntity("Cart Items",HttpStatus.OK);
		
		
	}
	

}
