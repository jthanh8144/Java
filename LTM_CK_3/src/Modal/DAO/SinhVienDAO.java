package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modal.BEAN.SinhVien;

public class SinhVienDAO {
	public ArrayList<SinhVien> getAllSV() {
		ArrayList<SinhVien> result = new ArrayList<SinhVien>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM sinhvien";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setIDSV(rs.getString("IDSV"));
				sinhVien.setTenSV(rs.getString("TenSV"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setIDK(rs.getString("IDK"));
				result.add(sinhVien);
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
	
	public ArrayList<SinhVien> getSVK(String IDK) {
		ArrayList<SinhVien> result = new ArrayList<SinhVien>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM sinhvien WHERE IDK = '" + IDK + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setIDSV(rs.getString("IDSV"));
				sinhVien.setTenSV(rs.getString("TenSV"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setIDK(rs.getString("IDK"));
				result.add(sinhVien);
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
	
	public void addSV(SinhVien s) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "INSERT sinhvien VALUES ('" + s.getIDSV() + "', '" + s.getTenSV() + "', '" + s.getGioiTinh() + "', '" 
					+ s.getIDK() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public String lastIDSV() {
		String result = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT max(IDSV) FROM sinhvien";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("max(IDSV)");
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
	
	public SinhVien getSV(String IDSV) {
		SinhVien sinhVien = new SinhVien();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM sinhvien WHERE IDSV = '" + IDSV + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				sinhVien.setIDSV(rs.getString("IDSV"));
				sinhVien.setTenSV(rs.getString("TenSV"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setIDK(rs.getString("IDK"));
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return sinhVien;
	}
	
	public void updateSV(SinhVien s) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "UPDATE sinhvien SET TenSV = '" + s.getTenSV() + "', GioiTinh = '" + s.getGioiTinh() + "', IDK = '" + s.getIDK() 
					+ "' WHERE IDSV = '" + s.getIDSV() + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void deleteSV(String IDSV) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test888";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "DELETE FROM sinhvien WHERE IDSV = '" + IDSV + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
}
