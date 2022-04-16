package test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class CRUDMethod {

	@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api";
		
		when().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Tobias")).
			log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		
		baseURI= "https://reqres.in/api";
		
		JSONObject payload=  new JSONObject();
		payload.put("name", "Rohit");
		payload.put("job", "IT");
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			header("Connection", equalTo("keep-alive")).
			log().body().
			log().headers();		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		baseURI="https://reqres.in/api";
		
		JSONObject payload= new JSONObject();
		payload.put("name", "Rohit");
		payload.put("job", "HR");
		
		given().
			body(payload.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().status().
			log().body().
			log().headers();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
		baseURI="https://reqres.in/api";
		
		JSONObject payload= new JSONObject();
		payload.put("name", "Rohit");
		payload.put("job", "CEO");
		
		given().
			body(payload.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().status().
			log().body().
			log().headers();
	}
	
	@Test
	public void testDelete() {
		baseURI="https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}
	
}
