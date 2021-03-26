package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import models.User;
import utils.ConnUtility;

public class UserDAOImpl implements UserDAO{
	
	private static Logger log = Logger.getLogger(UserDAOImpl.class);

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement stm = null;
		
		Connection conn = ConnUtility.getConnection();
		
		// Based on username get user_role_id to attach to the user object
		// In this DAO a new method to get user_role_id is needed.
		String sql = "insert into reimbursement.users (username, password, "
				+ "user_first_name, user_last_name, user_email, user_role_id"
				+ "values(?,?,?,?,?,?)";
		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		log.info("Retrieving user information from database...");
		
		Connection conn = ConnUtility.getConnection();
		String sql = "select * from reimbursement.ers_users where username = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				int userId = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int roleId = rs.getInt("user_role_id");
				
				user = new User(userId, userName, password, firstName, lastName, email, roleId);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<User>();
		
		try {
			Connection conn = ConnUtility.getConnection();
			String sql = "select * from reimbursement.ers_users";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int role = rs.getInt("user_role_id");

				User user = new User(userId, username, password, firstName, lastName, email, role);
				
				list.add(user);
				
			}
		
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}
		
		return list;
	}

}
