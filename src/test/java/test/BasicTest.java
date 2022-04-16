package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicTest {

	@Test
	public void test1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Body: " + response.getBody().asString());
		System.out.println("Response Headers: " + response.getHeaders());
		System.out.println("Response Header: " + response.getHeader("Content-Type"));
	}
}
