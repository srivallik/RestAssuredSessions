package com.qa.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherGetTests {

	@Test
	public void getWeatherDetailsTest() {
		
		//define the base url
		RestAssured.baseURI="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
		//create the http request
		
		RequestSpecification httpRequest=RestAssured.given();
		
		// make a request/execute the request
		
		Response response=httpRequest.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		//validate response body
		Assert.assertEquals(responseBody.contains("Login Credentials"), true);
		
		int statusCode=response.getStatusCode();
		
		System.out.println("the status code is: "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("the status line is: "+response.getStatusLine());
		
		// get the headers
		Headers headers=response.getHeaders();
		System.out.println("Headers are : "+headers);
		
		String contentTypeHeader=response.getHeader("Content-Type");
		
		System.out.println("content Type Header value is:  "+contentTypeHeader);
		
        String contentLengthHeader=response.getHeader("Content-Length");
		
		System.out.println("content Length Header value is:  "+contentLengthHeader);
        		
		
	}

}
