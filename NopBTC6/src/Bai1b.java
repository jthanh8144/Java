import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bai1b {
	public static void main(String args[]) {
		try {
			Class.forName("Sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:DATA", "", "");
			
			Statement stmt = con.createStatement();
			String sql = "select Table1.*";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Id\t Name \t\t Add \t\t Total");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String addresss = rs.getString("Addresss");
				double total = rs.getDouble("Total");
				System.out.println(id + "\t" + name + "\t\t" + addresss + "\t\t" + total);
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.print("Error" + e);
		}
	}
}
