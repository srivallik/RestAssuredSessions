package com.qa.rest.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_Post {
	
	@Test
	public void test1_post() {
		
		/*
		 * Map<String, Object> map=new HashMap<String, Object>(); map.put("name",
		 * "srivalli"); map.put("job", "tester");
		 */
		//System.out.println(map);
		
	    //JSONObject request=new JSONObject(map);  //data converted into json format
	    
		JSONObject request=new JSONObject();
		request.put("name", "srivalli");
		request.put("job", "tester");
	    
	    //System.out.println(request);
	    System.out.println(request.toJSONString());
	    
	    given().
	        header("Content-Type", "application/json").
	        contentType(ContentType.JSON).
	        accept(ContentType.JSON).
	        body(request.toJSONString()).
	    when().
	        post("https://reqres.in/api/users").
	    then().
	    statusCode(201);  //201 is for creation of new record
	    
	    
		
		
		
		
		
	}

}
