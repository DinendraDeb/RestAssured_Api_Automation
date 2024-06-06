package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestExamples {
	
	
	@Test
	public void test() {
		
		Response  response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int statusCode =response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	                  }
	
	@Test
	public void test1() 
	{
		
		baseURI = "https://reqres.in/api";
		//given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8));
		
		
	}

	

}
