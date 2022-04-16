package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidate {

	@Test
	public void getMethodSchemaValidate() {
		
		baseURI="https://reqres.in/api";
		
		when().
			get("/users").
		then().statusCode(200).
			assertThat().body(matchesJsonSchemaInClasspath("JSONSchema.json"));
	}	
}
