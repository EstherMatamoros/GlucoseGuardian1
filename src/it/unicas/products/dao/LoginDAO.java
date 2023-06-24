package it.unicas.products.dao;

import java.sql.*;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.LoginInfo;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo loginInfo)
	{
		boolean validStatus = false;
		try
		{
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM login_info WHERE user_name = '"+loginInfo.getUserName()+"' AND password = '"+loginInfo.getPassword()+"'");
			while(rs.next())
			{
				validStatus = true;
			}
			
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return validStatus;
	}

	public static int getUserIdByUserName(String userName) {
		int userId = 0; // Default value indicating failure
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement("SELECT user_id FROM login_info WHERE user_name = ?")) {
			pstmt.setString(1, userName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					userId = rs.getInt("user_id");
				}
			}
		} catch (SQLException e) {
			// Handle the exception gracefully, e.g., log the error or throw a custom exception
			e.printStackTrace();
		}
		return userId;
	}
}
