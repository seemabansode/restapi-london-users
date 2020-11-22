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
	
		/*
		 * Get all the users from base API
		 */

		@GetMapping("/users")
		public List<Object> getAllUsers() {
			
			return londonUserService.getAllUsers();
			
		}
		
		/*
		 * Get all the users whose Latitudes and Longitudes are within the 50 miles from London 
		 */
		
		@GetMapping("/users-london")
		public List<User> getLondonUsers() {
			
			return londonUserService.getLondonUsers();
			
		}
		
	
	
}
