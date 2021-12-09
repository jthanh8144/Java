package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modal.BEAN.Khoa;

public class KhoaDAO {
	public ArrayList<Khoa> getListKhoa() {
		ArrayList<Khoa> result = new ArrayList<Khoa>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM khoa";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Khoa khoa = new Khoa();
				khoa.setIDK(rs.getString("IDK"));
				khoa.setTenKhoa(rs.getString("TenKhoa"));
				result.add(khoa);
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
	
	public String getTenKhoa(String IDK) {
		String result = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT TenKhoa FROM khoa WHERE IDK = '" + IDK + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("TenKhoa");
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
}
