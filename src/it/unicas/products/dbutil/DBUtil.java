package it.unicas.products.dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection()
	{
		Connection conn = null;
		try 
		{
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection("jdbc:mysql://localhost/products?useSSL=false&serverTimezone=UTC", "products", "$Products2023$");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
