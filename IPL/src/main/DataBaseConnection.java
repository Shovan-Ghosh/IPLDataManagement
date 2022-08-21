package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	Connection conn = null;
	
	public static Connection makeConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			return conn;
		}
		catch (Exception e) {
			System.out.print("Connection Error");
			return null;
		}
		
	}
}
