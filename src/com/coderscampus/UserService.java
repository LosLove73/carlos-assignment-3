package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	// Method to create a User from a string array
	public User createUser(String[] stringInput) {
		// Check if the input has exactly 3 elements
		if (stringInput.length == 3) {
			return new User(stringInput[0], stringInput[1], stringInput[2]);
		} else {
			// Log or handle error for incorrect input format
			System.err.println("Invalid user data format: " + String.join(",", stringInput));
			return null; // Return null for invalid input
		}
	}

	// Method to parse a line of text into a string array
	public String[] parseText(String input) {
		return input.split(",");
	}

	// Method to read users from a file and convert to an array
	public User[] takeUsersFromFile(String filePath) {
		List<User> users = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] userInfo = parseText(line);
				User user = createUser(userInfo);
				if (user != null) {
					users.add(user); // Add to list instead of calling a non-existent method
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Convert list to array and return
		return users.toArray(new User[0]);
	}
}
