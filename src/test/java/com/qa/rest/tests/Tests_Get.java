package com.qa.rest.tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class Tests_Get {

	@Test
	public void test_1() {
		
		given().
		   header("Content-Type","application/json").
		   get("https://reqres.in/api/users?page=2").
		then().
		    statusCode(200).
		    body("data.email[5]",equalTo("rachel.howell@reqres.in")).
		    body("data.first_name",hasItems("Michael","Lindsay","Tobias")).
		    body("data.first_name[3]",equalTo("Byron"));
		    
		 //log().all();
		   
		
	}
	
}
