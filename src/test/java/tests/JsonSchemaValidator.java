package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonSchemaValidator {
	
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
		statusCode(200);
		}

}
