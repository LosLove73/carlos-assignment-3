package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {
	public static void main(String[] args) {
		UserService userService = new UserService();
		User[] users = userService.takeUsersFromFile("data.txt");
		try (Scanner scanner = new Scanner(System.in)) {
			int remainingAttempts = 5;
			
			while (remainingAttempts > 0) {
				System.out.println("Enter your username (email address): ");
				String inputUsername = scanner.nextLine();
				System.out.println("Enter your password: ");
				String inputPassword = scanner.nextLine();
				
				boolean isAuthenticated = false; // Variable to track authentication
				
				// Check against all users
				for (User user : users) {
					if (user.getUsername().equalsIgnoreCase(inputUsername) && 
							user.getPassword().equals(inputPassword)) {
						System.out.println("Welcome " + user.getName());
						isAuthenticated = true; // Set to true if authenticated
						break; // Exit loop after successful login
					}
				}
				
				if (isAuthenticated) {
					return; // Exit program if login is successful
				} else {
					remainingAttempts--;
					if (remainingAttempts > 0) {
						System.out.println("Invalid login, please try again.");
					} else {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
				}
			}
		}
	}
}
