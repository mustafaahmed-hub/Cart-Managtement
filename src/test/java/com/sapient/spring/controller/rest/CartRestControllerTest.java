package com.sapient.spring.controller.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;;
@SpringBootTest
public class CartRestControllerTest {
	/*
	 * 1-cart should return cart-item if present
	 * 2-posting a product to the cart should add the product to the cart
	 * 3-if cart is empty it should handle that exception
	 * 
	 */

	@Test
	public void shouldReturnListOfCartItems() {
		//specify the cart id
		given().log().all().when().get("http://localhost/8080/cart/cartId").then().statusCode(200).log().all();
		
	}
	@Test
	public void shouldAcceptAnProductAndToCart() {
		given().log().all().when().post().then().statusCode(201).log().all();
	}
}
