package tests;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class TestsOnLocalAPI {
	
	@Test
	
	public void get() 
	{
		baseURI = "http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	
    @Test
	
	public void post() 
	{
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("FirstName","Thomas");
		request.put("LastName","Edison");
		request.put("subjectId",1);
		request.put("id", 4);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201);
		
		
	}
    
@Test
	
	public void put() 
	{
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("FirstName","Albert");
		request.put("LastName","Einstein");
		request.put("subjectId",1);
		
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().put("/users/4").then().statusCode(200);
		
		
	}
	
	

}
