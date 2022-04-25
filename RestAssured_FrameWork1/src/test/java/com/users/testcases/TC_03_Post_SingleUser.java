package com.users.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.users.base.Testbase;
import com.users.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_03_Post_SingleUser extends Testbase {

	String name=RestUtils.username();
	String job=RestUtils.job();
	
	@BeforeClass
	void createUser() throws InterruptedException {
		print("TC 03 post New user started");
		RestAssured.baseURI="https://reqres.in/api/";
	
		httprequest=RestAssured.given();
		/*
		 * creating new records with below params
		 */
		JSONObject params=new JSONObject();
		params.put("name", name);
		params.put("job", job);
		
		httprequest.header("Content-Type","application/JSON");
		httprequest.body(params.toJSONString());
		
		// request response
		response=httprequest.request(Method.POST,"/users/2"); 
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {
		print("checking response body");
		String responsebody=response.getBody().asString();
		System.out.println("Body is:"+responsebody);
	}
	@Test
	void checkStatusCode() {
		print("checkStatusCode");
		int StatusCode=response.getStatusCode();
		System.out.println("StatusCode is:"+StatusCode);
		Assert.assertEquals(StatusCode, 201);
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
	@Test
	void checkUserNameField() {
		print("checkUserNameField");
		String username=response.jsonPath().getString("name");
		print("name of the user : "+username);
		Assert.assertEquals(username, name);
		
	}
	@AfterClass
	void teardown() {
		print("Test case 03 completed.");
	}
}
