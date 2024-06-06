package tests;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class GetandPostExamples {
	
	@Test
	public void testGet() 
	{
		
		baseURI= "https://reqres.in/api";
		//given().get("/users?page=2").then().statusCode(200).body("data[0].first_name", equalsTo("Michael")).body("data.first_name", hasItems("George","Rachel"));            
		
		
	}
	
	@Test
	public void testPost()
	
	    {
		
		Map<String, String> map = new HashMap<String, String>();
		/*
		 * map.put("name", "Dinendra"); map.put("job" , "Teacher");
		 * System.out.println(map);
		 */
		JSONObject request = new JSONObject();
		request.put("Name","Dinendra");
		request.put("Job", "Engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").then().statusCode(201).log().all();
		}
	
	@Test
	 public void testDelete() {
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
		
		
	}

}
