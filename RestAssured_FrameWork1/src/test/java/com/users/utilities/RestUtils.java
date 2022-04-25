package com.users.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	

	//to generate random usernames
	public static String username() {
		String username=RandomStringUtils.randomAlphabetic(1);
		
		return ("frameworkuser"+username);
	}
	//to generate random job titles
	public static String job() {
		String jobtitle=RandomStringUtils.randomAlphabetic(1);
		
		return ("jobcode"+jobtitle);
	}
	//to generate random age
	public static String age() {
		String age=RandomStringUtils.randomNumeric(1);
		
		return (age);
	}

}
