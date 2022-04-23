package com.employee.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GetAllEmployees extends Testbase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
		httprequest=RestAssured.given();
		// request response
		response=httprequest.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {
		print("checking response body");
	}
}
