package com.users.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.users.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_Get_All_Users extends Testbase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		print("TC 01 get All users started");
		RestAssured.baseURI="https://reqres.in/";
	
		httprequest=RestAssured.given();
		// request response
		response=httprequest.request(Method.GET,"api/users?page=2");
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {
		print("checking response body");
		String responsebody=response.getBody().asString();
		System.out.println("Body is:"+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	@Test
	void checkStatusCode() {
		print("checkStatusCode");
		int StatusCode=response.getStatusCode();
		System.out.println("StatusCode is:"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
	@Test
	void checkResponsetime() {
		print("checkResponsetime");
		long Responsetime=response.getTime();
		System.out.println("Responsetime is:"+Responsetime);
		if(Responsetime>4000)
			print("response time is longer than 4000");
		Assert.assertTrue(Responsetime<4000);
		
	}
	@Test
	void checkContentType() {
		print("checkContentType");
		String contenttype=response.header("Content-Type");
		System.out.println("content type : "+contenttype);
		Assert.assertEquals(contenttype, "application/json; charset=utf-8");
	}
	
	@AfterClass
	void teardown() {
		print("Test case 01 completed.");
	}
}
