package com.sapient.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.spring.model.CartItem;
import com.sapient.spring.model.Product;
import com.sapient.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartItemService cartItemService;
	
	
	
	public void addToCart(Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setItemName(product.getName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(1);
		cartItem.setId(product.getId());
		cartItemService.addToCart(cartItem);
		
	}
	public List<Product> showAllProduct() {
		return productRepository.fetchAllProducts();
	}
//	public List<Product> showAllElectronicsProduct() {
//		List<Product> products =productRepository.fetchAllProducts().stream().filter(product -> (product.getCategory()==1)).collect(Collectors.toList());
//		return products;
//		
//	}
//	public List<Product> showAllClothingProduct(){
//		List<Product> products = productRepository.fetchAllProducts().stream().filter(product->(product.getCategory()==0)).collect(Collectors.toList());
//		return products;
//	}
//	public List<Product> showAllBookProduct(){
//		List<Product> products = productRepository.fetchAllProducts().stream().filter(product -> product.getCategory()==2).collect(Collectors.toList());
//		return products;
//	}
//	public List<Product> showAllOtherProduct(){
//		List<Product> products = productRepository.fetchAllProducts().stream().filter(product ->product.getCategory()==3).collect(Collectors.toList());
//		return products;
//	}
	//admin function
	public void addTheProduct(Product product) {
		productRepository.saveProduct(product);
	}
	public List<Product> fetchProductBySpecificCategory(String category) {

		Map<String, Integer> categoryMapping = new HashMap<String, Integer>();
		categoryMapping.put("electronics", 1);
		categoryMapping.put("clothing", 0);
		categoryMapping.put("books", 2);
		categoryMapping.put("others", 3);
		
		int val = categoryMapping.get(category);
		List<Product> products = productRepository.fetchAllProducts().stream().filter(product ->product.getCategory()==val).collect(Collectors.toList());
		
		
		return products;
	}
	
	

}
