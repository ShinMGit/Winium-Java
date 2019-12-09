package com.pri.restAssuredTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestAPI2 extends RestBase{

	@Test
	public void test1() {
		int code = RestAssured.given()
				.auth().preemptive()
				.basic("ToolsQA", "TestPassword")
				.when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();
		System.out.println("Response Code from server is: " + code);
	}

	@Test
	public void test2() {
		int code = RestAssured.given()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();
		System.out.println("Response Code from server is: " + code);
	}
	
	@BeforeMethod
	public void testTestNG() {
		System.out.println("Testing Test NG Run");
	}
	
	@BeforeTest
	public void testTestNGforBeforeTest() {
		System.out.println("Before Test: I am first of all ============");
	}

}
