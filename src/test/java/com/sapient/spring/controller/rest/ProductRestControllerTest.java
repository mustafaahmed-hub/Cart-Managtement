package com.sapient.spring.controller.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;;
@SpringBootTest
public class ProductRestControllerTest {
	@Test
	public void shouldReturnListOfProduct() {
		given().log().all().when().get("http://localhost:8800/products").then().statusCode(200).log().all();

	}
	@Test
	public void shouldReturnProductOfSpecificCategory() {
		given().log().all().get("http://localhost:8800/products/electronics").then().statusCode(200).log().all();
	}
}
