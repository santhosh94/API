package com.users.base;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public static String userid="2";//hard coded for test purpose only
	
	@BeforeTest
	public void setup() {
		System.out.println("@BeforeTest: setup()");
	}
	
	public void print(String value) {
		System.out.println("******"+value+"*******");
			
	}
}
