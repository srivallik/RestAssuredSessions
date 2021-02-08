package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTestsSample {
	
	@Test
	public void getTests() {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/Mexico";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		System.out.println(responseBody.contains("Mexico City"));
		
		int statusCode=response.getStatusCode();
		System.out.println("status code: "+statusCode);
		
		String statusLine=response.getStatusLine();
		System.out.println("status line: "+statusLine);
		
		Headers headers=response.getHeaders();
		System.out.println("Headers are: "+headers);
		System.out.println("Server header is : "+headers.getValue("Server"));
		System.out.println("header value is: "+headers.getValue("Content-Type"));
		
		JsonPath jsonPathValue=response.jsonPath();
		System.out.println(jsonPathValue.get("name"));
		System.out.println(jsonPathValue.get("capital"));
		System.out.println(jsonPathValue.get("timezones"));
		System.out.println(jsonPathValue.get("languages"));	
		
		System.out.println("-------------------------------");
		
	}
	
	@Test(priority=1)
	public void getNegativeTests() {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/1234";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		System.out.println(responseBody.contains("Not Found"));
		
		int statusCode=response.getStatusCode();
		System.out.println("status code: "+statusCode);
		
	}

}
