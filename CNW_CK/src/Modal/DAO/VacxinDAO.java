package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modal.BEAN.Vacxin;

public class VacxinDAO {
	public String getLastID() {
		String result = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT max(MaVacxin) FROM vacxin";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("max(MaVacxin)");
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
	
	public ArrayList<Vacxin> getAllVX() {
		ArrayList<Vacxin> result = new ArrayList<Vacxin>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM vacxin";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Vacxin vacxin = new Vacxin();
				vacxin.setMaVacxin(rs.getString("MaVacxin"));
				vacxin.setTenVacxin(rs.getString("TenVacxin"));
				vacxin.setSoMui(rs.getInt("SoMui"));
				vacxin.setMoTa(rs.getString("MoTa"));
				vacxin.setGiaVacxin(rs.getInt("GiaVacxin"));
				vacxin.setTenHangSX(rs.getString("TenHangSX"));
				result.add(vacxin);
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
	
	public Vacxin getVX(String MaVacxin) {
		Vacxin vacxin = new Vacxin();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM vacxin WHERE MaVacxin = '" + MaVacxin + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				vacxin.setMaVacxin(rs.getString("MaVacxin"));
				vacxin.setTenVacxin(rs.getString("TenVacxin"));
				vacxin.setSoMui(rs.getInt("SoMui"));
				vacxin.setMoTa(rs.getString("MoTa"));
				vacxin.setGiaVacxin(rs.getInt("GiaVacxin"));
				vacxin.setTenHangSX(rs.getString("TenHangSX"));
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return vacxin;
	}
	
	public void addVX(Vacxin s) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "INSERT vacxin VALUES ('" + s.getMaVacxin() + "', '" + s.getTenVacxin() + "', '" + s.getSoMui() + "', '" 
					 + s.getMoTa() + "', '" + s.getGiaVacxin() + "', '" + s.getTenHangSX() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void updateVX(Vacxin s) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test999";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "UPDATE vacxin SET TenVacxin = '" + s.getTenVacxin() +  "', SoMui = '" + s.getSoMui() + "', MoTa = '" 
					 + s.getMoTa() + "', GiaVacxin = '" + s.getGiaVacxin() + "', TenHangSX = '" + s.getTenHangSX() + "' WHERE MaVacxin = '" + s.getMaVacxin() + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
}
