package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;

public class SOAPXMLRequest {
	
	@Test
	public void validateSOAPXml() throws Exception {
		
		File file = new File ("C:\\Users\\debdi\\OneDrive\\Desktop\\Calculator.xml");
		
		FileInputStream fis = new FileInputStream(file);
		
	    String ReqBody = IOUtils.toString(fis, "UTF-8") ;
		
		baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(ReqBody.toString()).
		when().
		post("/Calc.asmx?op=Add").then().
		statusCode(201).log().all().and().
		body("//*:AddResult.text()", equalTo(8));
		
		
	}

	
	

}
