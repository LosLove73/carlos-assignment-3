package com.coderscampus;

public class User {
	private String username;
	private String password;
	private String name;
	
	// Constructor to initialize username, password and name fields. 
	public User (String username, String password, String name) {
	this.username = username;
	this.password = password;
	this.name = name;
	}

	// Generate Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		
	}
	
    
}
