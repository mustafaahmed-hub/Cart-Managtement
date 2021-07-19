package com.sapient.spring.controller.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.spring.model.Product;

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
		
		given().log().all().when().get("http://localhost/8080/carts").then().statusCode(200).log().all();
		
	}
    @Test
    public void shouldAddProductInCart() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Product product1 =new Product("product-1",1,4,32.0,5);

        String product = mapper.writeValueAsString(product1);

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(product)
                .when()
                .post("http://localhost:8800/carts/17/addToCart")
                .then()
                .statusCode(201)
                .log().all();
    }
}
