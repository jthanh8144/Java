package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import Modal.BEAN.*;

public class AdminDAO {
	public void addUser(Admin ad) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "insert admin values ('" + ad.getRole() + "', '" + ad.getUsername() + "', '" + ad.getPassword() + "', '" 
					+ ad.getFirstname() + "', '" + ad.getLastname() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void delUser(String username) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "DELETE FROM admin WHERE username = '" + username + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void updateUser(String username, String role, String firstname, String lastname) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "UPDATE admin SET role = '" + role + "', firstname = '" + firstname + "', lastname = '" + lastname 
				+ "' WHERE username = '" + username + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public ArrayList<Admin> search(String inp) {
		ArrayList<Admin> result = new ArrayList<Admin>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin where (firstname LIKE N'%" + inp + "%' OR lastname LIKE N'%" + inp + "%')";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setRole(rs.getString("role"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setFirstname(rs.getString("firstname"));
				admin.setLastname(rs.getString("lastname"));
				result.add(admin);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		
		return result;
	}
	
	public ArrayList<Admin> getListUser() {
		ArrayList<Admin> result = new ArrayList<Admin>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setRole(rs.getString("role"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setFirstname(rs.getString("firstname"));
				admin.setLastname(rs.getString("lastname"));
				result.add(admin);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		
		return result;
	}
	
	public Admin getUser(String username) {
		Admin admin = new Admin();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM admin WHERE username = '" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				admin.setRole(rs.getString("role"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setFirstname(rs.getString("firstname"));
				admin.setLastname(rs.getString("lastname"));
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return admin;
	}
}
