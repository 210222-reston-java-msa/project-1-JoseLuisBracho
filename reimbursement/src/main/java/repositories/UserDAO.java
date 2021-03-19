package repositories;


import java.util.List;

import models.User;

public interface UserDAO {
	
	public boolean insertUser(User user);
	
	public boolean updateUser(User user);
	
	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);
	
	public List<User> findAll();

}
