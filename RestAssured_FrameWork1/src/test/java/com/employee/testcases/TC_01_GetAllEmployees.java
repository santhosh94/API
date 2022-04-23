package com.employee.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GetAllEmployees extends Testbase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		
		RestAssured.baseURI="https://reqres.in/api/users";
	
		httprequest=RestAssured.given();
		// request response
		response=httprequest.request(Method.GET,"?page=2");
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {
		print("checking response body");
		String responsebody=response.getBody().asString();
		System.out.println("Body is :"+responsebody);
	}
}
