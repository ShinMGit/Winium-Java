package com.pri.restAssuredTest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class RestBase {
	
	@BeforeClass
	public void setUp() {
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
	}

}
