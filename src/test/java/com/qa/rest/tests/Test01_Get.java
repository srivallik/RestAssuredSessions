package com.qa.rest.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class Test01_Get {

	@Test
	public void Test01_Get() {
		
		Response response=get("https://reqres.in/api/users/2");
		System.out.println(response.getBody());
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("get body: "+response.getBody().asString());
		System.out.println("Status Line is: "+response.getStatusLine());
		System.out.println("Header is: "+response.getHeader("Connection"));
		System.out.println("Cookie is: "+response.getCookie("cfduid"));
		Headers headers=response.getHeaders();
		System.out.println("Headers are: "+headers);
		JsonPath jsonPathValue=response.jsonPath();
		System.out.println("json path value: "+jsonPathValue);
			
		
	}
	
	@Test
	public void Test02_Get() {
		
		given()
		    .get("https://reqres.in/api/unknown/2")
		.then()
		    .statusCode(200)
		    .body("data.id", equalTo(2));
		
		
	}
	
}
