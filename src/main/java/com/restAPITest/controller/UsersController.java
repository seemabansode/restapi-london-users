package com.restAPITest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.restAPITest.service.LondonUserService;



public class UsersController {

	@Autowired
	private LondonUserService londonUserService;
	
	    //getAllUsers Method
		@GetMapping("/users")
		public List<Object> getAllUsers() {
			
			return londonUserService.getAllUsers();
			
		}
		
	
	
	
	
}
