package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		User[] users = userService.takeUsersFromFile("data.txt"); // stores data read from data.txt doc in an Array of User objects called users. 
		try (Scanner scanner = new Scanner(System.in)) {
			int remainingAttempts = 5;
			
			while (remainingAttempts > 0) {
				System.out.println("Enter your username (email address): ");
				String inputUsername = scanner.nextLine();
				System.out.println("Enter your password: ");
				String inputPassword = scanner.nextLine();
				
				// used to determine if there is a match between the user input against data read from the file. 
				for (User user : users) {
					if (user.getUsername().equalsIgnoreCase(inputUsername) && 
							user.getPassword().equals(inputPassword)) {
						System.out.println("Welcome " + user.getName());
						return;
					}
				}
				// decrements remainingAttemtps by 1 after each iteration. 
				remainingAttempts --;
				if (remainingAttempts > 0) {
					System.out.println("Invalid login, please try again.");
				} else {
					System.out.println("Too many failed login attempts, you are now locked out.");
				}
			}
		}

	}

}
