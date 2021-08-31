import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bai2_2 {
	private static String url;
	private static Connection con;
	private static File f1 = new File("D:/Java/d1.txt");
	private static File f2 = new File("D:/Java/d2.txt");
	private static File fo = new File("D:/Java/error2.txt");
	private static List<String> data = new ArrayList<>();
	
	public static void ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://ACERNITRO5:1433; DatabaseName=java2";
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("Ket noi csdl thanh cong.");
		}catch(Exception ex) {
			System.out.print("Connect fail: " + ex);
		}
	}
	
	public static void DocFile(File f) {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
			fr.close();
		    br.close();
			System.out.println("Doc file thanh cong.");
		} catch (Exception ex) {
			System.out.print("Loi doc file: " + ex);
		}
	}
	
	public static void GhiVaoDB() {
		try {
			Statement stmt = con.createStatement();
			for (int i = 0; i < data.size(); i++) {
				String query = "insert THANHVIEN values ('";
				String[] info = data.get(i).trim().split(", ");
				query += info[0] + "', '" + info[1] + "', '" + info[2] + "', '" + info[3] + "', '" + info[4] + "', '" + info[5] + "', 0)";
				stmt.executeUpdate(query);
			}
			stmt.close();
			System.out.println("Them vao database thanh cong.");
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void UpdateDB() {
		try {
			FileWriter fw = new FileWriter(fo);
			Statement stmt = con.createStatement();
			
			ArrayList<String> listID = new ArrayList<>();
			String MaTV = "select MaThanhVien from THANHVIEN";
			ResultSet rs0 = stmt.executeQuery(MaTV);
			while (rs0.next()) {
				listID.add(rs0.getString("MaThanhVien"));
			}
			
			for (int i = 0; i < data.size(); i++) {
				boolean isTrue = true;
				String[] info = data.get(i).trim().split(", ");
				
				boolean isIDTrue = false;
				for (String ID : listID) {
					if (info[0].equals(ID) == true) {
						isIDTrue = true;
						break;
					}
				}
				if (isIDTrue == false) {
					isTrue = false;
					fw.write("Dong " + (i + 1) + ": Ma thanh vien khong ton tai trong database\n");
				}
				
				try {
					for (int j = 0; j < info[1].length(); j++) {
						if ((info[1].charAt(j) < 48 || info[1].charAt(j) > 57) && info[1].charAt(j) != '.') {
							isTrue = false;
							throw new Exception("Dong " + (i+1) + ": Diem thuong khong phai la so nguyen duong\n");
						}
					}
					if (Float.parseFloat(info[1]) > 500) {
						isTrue = false;
						throw new Exception("Dong " + (i + 1) + ": Diem thuong vuot qua 500\n");
					}
				}
				catch (Exception ex) {
					fw.write(ex.getMessage());
				}
				
				if (!(info[2].equals("VIP") == true || info[2].equals("NOR") == true)) {
					isTrue = false;
					fw.write("Dong " + (i + 1) + ": Level khong phai la VIP hoac NOR\n");
				}
				
				if (isTrue == true) {
					float cpn = 0, heso = 0;
					String select = "select ChiPhiNhan from THANHVIEN where MaThanhVien = '" + info[0] + "'";
					ResultSet rs = stmt.executeQuery(select);
					while (rs.next()) {
						cpn = rs.getFloat("ChiPhiNhan");
					}
					if (info[2].equals("VIP")) {
						heso = 50000;
					}
					if (info[2].equals("NOR")) {
						heso = 20000;
					}
					String query = "update THANHVIEN set ChiPhiNhan = " + (cpn + Float.parseFloat(info[1])*heso) + " where MaThanhVien = '" + info[0] + "'";
//					stmt.executeUpdate(query);
				}
			}
			stmt.close();
			fw.close();
			System.out.println("Update database thanh cong.");
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void main(String[] args) {
		ConnectDB();
//		DocFile(f1);
//		GhiVaoDB();
//		data.clear();
		DocFile(f2);
		UpdateDB();
	}
}
