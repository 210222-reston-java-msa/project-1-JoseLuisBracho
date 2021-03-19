package services;

import java.util.List;

import models.User;
import repositories.UserDAO;
import repositories.UserDAOImpl;

public class UserService {
	
	public static UserDAO userDao = new UserDAOImpl();
	
	public static User getUserbyUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public static List<User> getAll() {
		return userDao.findAll();
	}

	public static User checkLogin(String username, String password) {
		User user = getUserbyUsername(username);
		
		if (user == null) {
			return null;
		}
		
		if (user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
	
	
	public static int getRole(String username, String password) {
		
		int role = 0;
		
		User user = getUserbyUsername(username);
		
		if (user.getUsername().equals(username) & user.getPassword().equals(password)) {
			
			role = user.getRole();
		}
		
		return role;
		
	}

}
