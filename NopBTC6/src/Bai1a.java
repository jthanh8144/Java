import java.sql.*;

public class Bai1a {
	public static void main(String args[]) {
		System.out.println("Ket noi csdl");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://ACERNITRO5:1433; DatabaseName=DATA";
			Connection con = DriverManager.getConnection(url, "sa", "123456");
			
			Statement stmt = con.createStatement();
			String sql = "select * from Table1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String addresss = rs.getString("Addresss");
				double total = rs.getDouble("Total");
				System.out.println("ID = " + id + " Name = " + name + " Add = " + addresss + " Total = " + total);
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.print("Error" + e);
		}
	}
}
