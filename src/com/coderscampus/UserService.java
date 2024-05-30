package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	// method to convert an array of strings (represented by a line of data from a file) into a User object.
	public User createUser(String[] stringInput) { 
	// the 3 elements in the stringInput array correspond to 'username', 'password', and 'name' from User class.
		return new User(stringInput[0], stringInput[1], stringInput[2]); 
			}	
	
	public String[] parseText(String input) {
        return input.split(",");
    }
	
	// method to read file line by line converting each line into an array of strings.
	public User[] takeUsersFromFile(String filePath) {
		List<User> users = new ArrayList<>(); // --> initializes an empty ArrayList 'users' to store User objects.
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine())!= null) {
				String[] userInfo = parseText(line);
				User user = createUser(userInfo);
				user.add(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	// Converts the ArrayList 'users' to an array of User objects and returns it.
		return users.toArray(new User[0]);
	}
	
	
}
	
	