package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String url;
	private static String user;
	private static String password;
	

	public static void setUrl(String url) {
		ConnectionProvider.url = url;		
	}

	public static void setUser(String user) {
		ConnectionProvider.user = user;		
	}

	public static void setPassword(String pw) {
		ConnectionProvider.password = pw;		
	}

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
