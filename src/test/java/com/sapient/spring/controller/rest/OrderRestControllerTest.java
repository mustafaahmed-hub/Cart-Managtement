package com.sapient.spring.controller.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;;

@SpringBootTest
public class OrderRestControllerTest {
	
	@Test
	public void shouldPlaceAnOrder() {
		given().log().all().when().get("http://localhost/8080/orders/checkout/17").then().statusCode(200).log().all();
		
	}
}
