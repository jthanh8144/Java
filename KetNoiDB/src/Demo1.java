import java.sql.*;
import javax.sql.*;

public class Demo1 {
	public static void main(String args[]) {
		System.out.println("Ket noi csdl");
		try {
			//Ket noi su dung jdbc:odbc
//			Class.forName("Sun.jdbc.odbc.JdbcOdbcDriver");
//			Connection con = DriverManager.getConnection("jdbc:odbc:DATA", "", "");
			//Ket noi truc tiep den he quan tri csdl MySQL
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DA");
			//Ket noi truc tiep den he quan tri sql server
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://ACERNITRO5:1433; DatabaseName=DATA";
			Connection con = DriverManager.getConnection(url, "sa", "123456");

			Statement stmt = con.createStatement();
			
//			String sql121 = "insert Table1 values (5, 'Thanh Van Vo', 'QNAM', 5)";
//			stmt.executeUpdate(sql121);
//			String sql122 = "update ...";
//			stmt.executeUpdate(sql122);
			String sql = "select * from Table1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String addresss = rs.getString("Addresss");
				double total = rs.getDouble("Total");
				System.out.println("ID = " + id + " Name = " + name + " Add = " + addresss + " Total = " + total);
				System.out.println("\n");
				
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.print("Error" + e);
		}
	}
}
