package com.sapient.spring.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.sapient.spring.model.Product;

/*
 * category mapping -  
 * 0- clothing
 * 1- electronics
 * 2-books
 * 3-others
 */

@Repository
public class ProductRepository {
	private List<Product> products = new ArrayList<>();
	@PostConstruct
	public void populateInitialProductList() {
		products.add(new Product("book-1",101,2,100.0,2));
		products.add(new Product("book-2",102,2,100.0,2));
		products.add(new Product("cloth-2",103,2,100.0,0));
		products.add(new Product("electronics-1",104,2,100.0,1));
		products.add(new Product("electronics-2",105,2,100.0,1));
		products.add(new Product("other-1",104,2,100.0,3));
		products.add(new Product("other-2",104,2,100.0,3));
		
		
		
	}
	
	public void saveProduct(Product product) {
		this.products.add(product);
	}
	
	public List<Product> fetchAllProducts() {
		return this.products;
	}

}
