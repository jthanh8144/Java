package Modal.DAO;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement; 

public class CheckLoginDAO {
	public boolean isExistUser(String userName, String password) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin where username = '" + userName + "' and password = '" + password + "'";
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
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
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
