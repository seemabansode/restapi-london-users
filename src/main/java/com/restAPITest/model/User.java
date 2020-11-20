package com.restAPITest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("first_name")
	private String firstname;
	
	@JsonProperty("last_name")
	private String lastname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("ip_address")
	private String ipAddress;
	
	@JsonProperty("latitude")
	private double latitude;
	
	@JsonProperty("longitude")
	private double longitude;
	

}
