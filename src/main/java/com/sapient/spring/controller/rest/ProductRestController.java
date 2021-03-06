package com.sapient.spring.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.spring.model.Product;
import com.sapient.spring.service.ProductService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
    public ResponseEntity<List<Product>> showListOfProducts(){
        List<Product> products = productService.showAllProduct();
        return new ResponseEntity(products, HttpStatus.OK);
    }
//	@GetMapping("products/{category}")
//	public ResponseEntity<List<Product>> showListOfProductsOfCategory(@PathVariable(value = "category") String category){
//		List<Product> products = productService.fetchProductBySpecificCategory(category);
//		return new ResponseEntity(products, HttpStatus.OK);
//	}
    @PostMapping("/products")
    public ResponseEntity addProduct( @RequestBody Product product){
        log.info("Product to be added : {}",product);
        productService.addTheProduct(product);
        return new ResponseEntity("Product has been created successfully", HttpStatus.CREATED);

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> showProductById(@PathVariable Long id){
    	Product product = productService.fetchProductById(id);
    	return new ResponseEntity(product, HttpStatus.OK);
    	
    }
//    not go this way 
//    @PostMapping("products/{id}/addToCart")
//    public ResponseEntity addToCart(@PathVariable(value = "product_id")Long id ,@RequestBody Product product) {
//    	
//    	productService.addToCart(product);
//    	return new ResponseEntity("Product has been added in the cart",HttpStatus.CREATED);
//    }

}
