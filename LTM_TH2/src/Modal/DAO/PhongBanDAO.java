package Modal.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modal.BEAN.*;

public class PhongBanDAO {
	public ArrayList<PhongBan> getListPB() {
		ArrayList<PhongBan> result = new ArrayList<PhongBan>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM phongban";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				PhongBan PhongBan = new PhongBan();
				PhongBan.setIDPB(rs.getString("IDPB"));
				PhongBan.setTenPB(rs.getString("TenPB"));
				PhongBan.setMoTa(rs.getString("MoTa"));
				result.add(PhongBan);
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
	
	public PhongBan getPB(String IDPB) {
		PhongBan PhongBan = new PhongBan();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM phongban where IDPB = '" + IDPB + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				PhongBan.setIDPB(rs.getString("IDPB"));
				PhongBan.setTenPB(rs.getString("TenPB"));
				PhongBan.setMoTa(rs.getString("MoTa"));
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
		return PhongBan;
	}
	
	public String getLastIDPB() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT max(IDPB) FROM phongban";
			ResultSet rs = stmt.executeQuery(sql);
			String lastID = "";
			while (rs.next()) {
				lastID = rs.getString("max(IDPB)");
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
	
	public void addPB(PhongBan pb) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "insert phongban values ('" + pb.getIDPB() + "', '" + pb.getTenPB() + "', '" + pb.getMoTa() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
	
	public void updatePB(PhongBan pb) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/dulieu";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "UPDATE phongban SET TenPB = '" + pb.getTenPB() + "', MoTa = '" + pb.getMoTa() + "' WHERE IDPB = '" + pb.getIDPB() + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error " + ex);
		}
	}
}
