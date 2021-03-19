package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnUtility {
	
private static Logger log = Logger.getLogger(ConnUtility.class);
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		Connection conn = null;
		
		try {
			props.load(loader.getResourceAsStream("creds.properties"));
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {

				log.warn("Unable to connect to the database !");
				e.printStackTrace();
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		return conn;
		
	}

}
