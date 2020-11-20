package com.restAPITest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class LondonUserService {

	@Autowired
	private RestTemplate restTemplate;
	
	//Base url to get called
	private String url = "https://bpdts-test-app.herokuapp.com/";
	
	public List<Object> getAllUsers() {
		
		Object[] allUsers = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(allUsers);
		
	}
	
	
	
}
