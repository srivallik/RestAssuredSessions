package com.qa.rest.tests;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPostRequest {
	
	@Test
	public void submitForm() {
		
		//1. defibe the base url
		RestAssured.baseURI="https://www.example.com";
		
		//2. define the http request
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//3. Create a JSON object with all the fields
		JSONObject requestJSON=new JSONObject();
		
		requestJSON.put("username", "user@site.com");
		requestJSON.put("password", "Pas54321");
		
		
		//4. add header 
		httpRequest.header("Accept","ContentType.JSON.getAcceptHeader()");
		
		//5. add the json payload to the body of the request
		httpRequest.body(requestJSON.toJSONString());
		
		//6. post the request and get the response
		Response response=httpRequest.post("/login");
		
		//7. get the response body
        String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		
		
		
		
		
		
		
	}

}
