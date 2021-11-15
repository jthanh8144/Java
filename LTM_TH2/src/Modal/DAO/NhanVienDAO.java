package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modal.BEAN.NhanVien;

public class NhanVienDAO {
	public ArrayList<NhanVien> getListNV() {
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM nhanvien";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				NhanVien NhanVien = new NhanVien();
				NhanVien.setIDNV(rs.getString("IDNV"));
				NhanVien.setHoTen(rs.getString("HoTen"));
				NhanVien.setIDPB(rs.getString("IDPB"));
				NhanVien.setDiaChi(rs.getString("DiaChi"));
				result.add(NhanVien);
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
	
	public ArrayList<NhanVien> getListNVPB(String IDPB) {
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM nhanvien where IDPB = '" + IDPB + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				NhanVien NhanVien = new NhanVien();
				NhanVien.setIDNV(rs.getString("IDNV"));
				NhanVien.setHoTen(rs.getString("HoTen"));
				NhanVien.setIDPB(rs.getString("IDPB"));
				NhanVien.setDiaChi(rs.getString("DiaChi"));
				result.add(NhanVien);
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
	
	public ArrayList<NhanVien> getListNVSearch(String select, String inp) {
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM nhanvien where " + select + " = '" + inp + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				NhanVien NhanVien = new NhanVien();
				NhanVien.setIDNV(rs.getString("IDNV"));
				NhanVien.setHoTen(rs.getString("HoTen"));
				NhanVien.setIDPB(rs.getString("IDPB"));
				NhanVien.setDiaChi(rs.getString("DiaChi"));
				result.add(NhanVien);
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
	
	public void addNV(NhanVien nv) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "insert nhanvien values ('" + nv.getIDNV() + "', '" + nv.getHoTen() + "', '" + nv.getIDPB() + "', '" + nv.getDiaChi() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void updateNV(NhanVien nv) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "UPDATE nhanvien SET HoTen = '" + nv.getHoTen() + "', IDPB = '" + nv.getIDPB() + "', DiaChi = '" + nv.getDiaChi()
				+ "' WHERE IDNV = '" + nv.getIDNV() + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public String getLastIDNV() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT max(IDNV) FROM nhanvien";
			ResultSet rs = stmt.executeQuery(sql);
			String lastID = "";
			while (rs.next()) {
				lastID = rs.getString("max(IDNV)");
			}
			rs.close();
			stmt.close();
			return lastID;
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return "";
	}
	
	public void deleteNV(String IDNV) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "DELETE FROM nhanvien WHERE IDNV = '" + IDNV + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void deleteNVs(String[] IDNVs) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			for (int i = 0; i < IDNVs.length; i++) {
				String sql = "DELETE FROM nhanvien WHERE IDNV = '" + IDNVs[i] + "'";
				stmt.executeUpdate(sql);
			}
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public NhanVien getNV(String IDNV) {
		NhanVien nv = new NhanVien();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM nhanvien where IDNV = '" + IDNV + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				nv.setIDNV(rs.getString("IDNV"));
				nv.setHoTen(rs.getString("HoTen"));
				nv.setIDPB(rs.getString("IDPB"));
				nv.setDiaChi(rs.getString("DiaChi"));
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return nv;
	}
}
