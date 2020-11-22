package com.restAPITest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.restAPITest.model.User;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


@Service
public class LondonUserService {

	@Autowired
	private RestTemplate restTemplate;
	
	//Base url to get called
	private String url = "https://bpdts-test-app.herokuapp.com/users";
	
		
	
	public List<Object> getAllUsers() {
		
		Object[] allUsers = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(allUsers);
		
	}
	
	
	public List<User> getLondonUsers() {
		
		List<User> usersWithinLondon = new ArrayList<>();
		
		/*
         * Consume the base API using restTemplate
         */
		
		ResponseEntity<User[]> allUsers =  restTemplate.getForEntity( url, User[].class);
		
		User[] user = allUsers.getBody();
		
				
		/*
         * London decimal coordinates - latitude and longitude
         */
        double londonLatitude = 51.509865;
        double londonLongitude = -0.118092;
        
        /*
         * Variable to set the distance limit, as per users requirement the distance can be changed, 
         * currently it is set to 50 miles as per requirement given  
         */
        int distanceToBeCalculated = 50;
        
        /*
         * Fetching each User object to check the distance from the user location and London location 
         */
        
        
        for (int i = 0; i <user.length ; i++) { 
		
        	User currentUser = user[i];
        	
        	int userId = currentUser.getId();
        	String userFirstname = currentUser.getFirstname();
        	String userLastname = currentUser.getLastname();
        	String userEmail = currentUser.getEmail();
        	String userIpAddress = currentUser.getIpAddress();
        	double userLatitude = currentUser.getLatitude();
        	double userLongitude = currentUser.getLongitude();
		
		
		/*
         * Calculate the distance between Center of London and location of new record in meters 
         */
        GeodesicData result =
                Geodesic.WGS84.Inverse(londonLatitude, londonLongitude, userLatitude, userLongitude);

            double distanceInMeters = result.s12;
            
            /*
             * Convert the distance in miles
             */
            double distanceInMiles = distanceInMeters / 1609.34;
            
            /*
             * Add the Users within 50 miles of London into usersWithinLondon List
             */
            
            if (distanceInMiles <= distanceToBeCalculated)
            {
            	 User newUser = new User();
                 newUser.setId(userId);
                 newUser.setFirstname(userFirstname);
                 newUser.setLastname(userLastname);
                 newUser.setEmail(userEmail);
                 newUser.setIpAddress(userIpAddress);
                 newUser.setLatitude(userLatitude);
                 newUser.setLongitude(userLongitude);

                 usersWithinLondon.add(newUser);
            	
            }
		
		
        }
        
        /*
         * return the usersWithinLondon List object
         */
        
        		return usersWithinLondon;
		
	}
	
}
