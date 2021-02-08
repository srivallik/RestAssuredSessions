package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTestsExample {
	
	@Test
	public void getExample() {
		
		RestAssured.baseURI="http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		Headers headers=response.getHeaders();
		System.out.println("Date Headers are: "+headers.getValue("Date"));
		
		System.out.println(headers.get("Connection"));
		
		/*
		 * JsonPath jsonPathValue=response.jsonPath();
		 * System.out.println(jsonPathValue.get("firstName"));
		 * System.out.println(jsonPathValue.get("lastName"));
		 */
		
		
		
		
	}

}
