package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestStaticImport {

	@Test
	public void testGetMthod() {

		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("data[2].first_name", equalTo("Tobias"));
	}

}
