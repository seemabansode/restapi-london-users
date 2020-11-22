package com.restAPITest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restAPITest.model.User;
import com.restAPITest.service.LondonUserService;


@RestController
public class UsersController {

	@Autowired
	private LondonUserService londonUserService;
	
	    //getAllUsers Method
		@GetMapping("/users")
		public List<Object> getAllUsers() {
			
			return londonUserService.getAllUsers();
			
		}
		
		
		@GetMapping("/users-london")
		public List<User> getLondonUsers() {
			
			return londonUserService.getLondonUsers();
			
		}
		
	
	
		@GetMapping("/helloworld1")
		public String helloWorld()
		{
			return "Hello World with GetMapping";
		}
	
}
