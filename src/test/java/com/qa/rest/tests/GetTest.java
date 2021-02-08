package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetTest {
	
	@Test
	public void getTest() {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/norway";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		
		System.out.println("response body: "+responseBody);
		System.out.println(responseBody.contains("Oslo"));
		
		int statusCode=response.getStatusCode();
		
		System.out.println("Status Code:"+statusCode);
		Assert.assertEquals(200, statusCode);          // status 200
		
		String statusLine=response.getStatusLine();
		System.out.println("status Line:"+statusLine);
		
		Headers headers=response.getHeaders();
		System.out.println("Headers are: "+headers);
		
		System.out.println("Server header is : "+headers.getValue("Server"));
		
		System.out.println("Content-Type header is: "+response.getHeader("Content-Type"));
		
		JsonPath jsonPath=response.jsonPath();
		
		System.out.println(jsonPath.get("name"));
		
		System.out.println(jsonPath.get("capital"));
		
		System.out.println(jsonPath.get("region"));
	    
		System.out.println(jsonPath.get("population"));
		
		System.out.println("-----------------------------");
	
	}

	
	@Test(priority=1)
	public void getNegativeTest() {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/123";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		
		System.out.println("response body: "+responseBody);
		System.out.println(responseBody.contains("Not Found"));
		
		int statusCode=response.getStatusCode();
		
		System.out.println("Status Code:"+statusCode);
		Assert.assertEquals(404, statusCode);
		
			
	}
}
