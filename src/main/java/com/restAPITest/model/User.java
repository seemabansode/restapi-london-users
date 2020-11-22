package com.restAPITest.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
	
	/*
     * Define Json properties 
     */
	
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
	
	
	
	/*
     * Getters and Setters 
     */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	
	

}
