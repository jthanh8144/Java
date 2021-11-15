package Modal.DAO;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement; 

public class CheckLoginDAO {
	public boolean isExistUser(String userName, String password) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
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
	
//	public ArrayList<Wife> getWifeList(String userName) {
//		ArrayList<Wife> result = new ArrayList<Wife>();
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
//			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
//			Statement stmt = (Statement) con.createStatement();
//			String sql = "SELECT * FROM ltm";
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			while (rs.next()) {
//				Wife wife = new Wife();
//				wife.setName(rs.getString("name"));
//				wife.setAddress(rs.getString("address"));
//				wife.setAlive(rs.getBoolean("alive"));
//				result.add(wife);
//			}
//			rs.close();
//			stmt.close();
//		}
//		catch(Exception ex)
//		{
//			System.out.println("Error " + ex);
//		}
//		
//		return result;
//	}
}
