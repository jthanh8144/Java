import java.sql.*;
import javax.sql.*;

public class Demo2 {
	public static void main(String args[]) {
		System.out.println("Ket noi csdl");
		try {
			//Ket noi truc tiep den he quan tri csdl MySQL
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql110.epizy.com:3306/epiz_29649935_testDB", "epiz_29649935", "dGDVMnZy35");

			Statement stmt = con.createStatement();
			
//			String sql121 = "insert Table1 values (5, 'Thanh Van Vo', 'QNAM', 5)";
//			stmt.executeUpdate(sql121);
//			String sql122 = "update ...";
//			stmt.executeUpdate(sql122);
			String sql = "select * from SINHVIEN";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("TenSV");
				int msv = rs.getInt("MaSV");
				int namsinh = rs.getInt("NamSinh");
				System.out.println("Ten = " + name + " MSV = " + msv + " NamSinh = " + namsinh);
				System.out.println("\n");
				
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.print("Error" + e);
		}
	}
}
