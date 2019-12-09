package com.pri.restAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pri.utilityHelper.Constants;

import static io.restassured.RestAssured.*;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class TestAPI {

	//private static final String APIURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	
	public static void main(String[] args) {
		/*Response resp =get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code = resp.getStatusCode();*/
		
		int code = get(Constants.getApiuri()).getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		testBody();
		
	}
	
	public static void testBody() {
		/*Response resp = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String data = resp.asString();*/
		
		String data = get(Constants.getApiuri()).asString();
		
		System.out.println("Data is: " + data);
		
		long time = get(Constants.getApiuri()).getTime();
		System.out.println("Response Time: " + time);
		
		String contentType = get(Constants.getApiuri()).getContentType();
		System.out.println(contentType);
		
		String vsl  = get(Constants.getApiuri()).print();
		System.out.println(vsl);
		
		String statusLine = get(Constants.getApiuri()).getStatusLine();
		System.out.println(statusLine);
		
		
		

		
		

	}
	

}
