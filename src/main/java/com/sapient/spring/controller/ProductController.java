package com.sapient.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sapient.spring.model.Product;
import com.sapient.spring.repository.ProductRepository;
import com.sapient.spring.service.ProductService;

@Controller

public class ProductController {
		@Autowired
		ProductRepository productRepository;
		@Autowired
		ProductService productService;
		
		@GetMapping("/show-products-not-rest")
		public String showAllProducts(Model model) {
			List<Product> products = productService.showAllProduct();
			model.addAttribute("products", products);
			return "products";
		}
//		@GetMapping("/show-products-not-rest-electronics")
//		public String showElectronicsProduct(Model model){
//			List<Product> products = productService.showAllElectronicsProduct();
//			model.addAttribute("products",products);
//			return "products";
//			
//		}
//		@GetMapping("/show-products-not-rest-clothing")
//		public String showClothingProduct(Model model) {
//			List<Product> products = productService.showAllClothingProduct();
//			model.addAttribute("products" ,products);
//			return "products";
//		}
		
		@GetMapping("/add-product-not-rest")
		public String addProductFromPage(Model model) {
			model.addAttribute("product", new Product());
			return "add-product";
		}
		
		
		
}
