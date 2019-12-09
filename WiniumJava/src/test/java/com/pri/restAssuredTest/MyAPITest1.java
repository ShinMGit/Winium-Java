package com.pri.restAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import io.restassured.matcher.RestAssuredMatchers.*;

public class MyAPITest1 {

	private static final String BASEURL = "http://restapi.demoqa.com/utilities/weather/city";
	
	@Test
	public void atestapi1() {
		System.out.println("=====testapp1 method=====");
		
		RestAssured.baseURI = BASEURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Bangalore");
		
		int resCode = response.getStatusCode();
		System.out.println("=====Response Code ======" + resCode);
		
		String resLine = response.getStatusLine();
		System.out.println("=====Status Line ======" + resLine);
		
		String res = response.asString();
		
		System.out.println("Response Body is =>  " + res);
		
	}
	
	@Test
	public void btestapi2() { 
		System.out.println("=====testapp2 method=====");
		
		RestAssured.baseURI = BASEURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Bangalore");
		
		// Get JSON Representation from Response Body 
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		// Get specific element from JSON document 
		String temp = jsonPathEvaluator.get("Temperature");
		
		System.out.println("======Value of Temperature is =======" + temp);
		
		// Validate if the specific JSON element is equal to expected value
		Assert.assertTrue(temp.contains("Degree"));
	}
	
	@Test
	public void ctestapi3() {
		System.out.println("=====testapp3 method=====");
		
		RestAssured.baseURI = BASEURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Imphal");
		
		// Get Response Body 
		ResponseBody body = response.getBody();
		
		// Get Response Body as String 
		String bodyStringValue = body.asString();
		
		System.out.println("======Body of the API Response is: =======" + bodyStringValue);
		
		// Validate if Response Body Contains a specific String
		Assert.assertTrue(bodyStringValue.contains("WeatherDescription"));
		
		// Get JSON Representation from Response Body 
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    
	    // Get specific element from JSON document 
	    String windSpeed = jsonPathEvaluator.get("WindSpeed");
	    String city = jsonPathEvaluator.get("City");
	    String wed = jsonPathEvaluator.get("WeatherDescription");
	    
	    System.out.println("======Wind Speed is: =======" + windSpeed);
	    System.out.println("======City is: =======" + city);
	    System.out.println("======Weather Description is: =======" + wed);
	    
	    // Validate if the specific JSON element is equal to expected value
	    Assert.assertTrue(windSpeed.contains("Km per hour"));
	    Assert.assertEquals(response.statusCode(), 200);
	    
	}
	
}
