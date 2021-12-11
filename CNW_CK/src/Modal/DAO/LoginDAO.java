package Modal.DAO;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement; 

public class LoginDAO {
	public boolean isExistUser(String userName, String password) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin where user = '" + userName + "' and pass = '" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				rs.close();
				stmt.close();
				return true;
			} else {
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return false;
	}
	
	public boolean isAdmin(String username) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin where username = '" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				if (rs.getString("role").equals("admin") == true) {
					rs.close();
					stmt.close();
					return true;
				} else {
					rs.close();
					stmt.close();
					return false;
					
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return false;
	}
}
