import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class Bai2 {
	private static String url;
	private static Connection con;
	private static File fi = new File("D:/Java/input.txt");
	private static File fo = new File("D:/Java/error.txt");
	private static List<String> data = new ArrayList<>();
	
	public static void ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://ACERNITRO5:1433; DatabaseName=DATA";
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("Ket noi csdl thanh cong.");
		}catch(Exception ex) {
			System.out.print("Connect fail: " + ex);
		}
	}
	
	public static void DocFile() {
		try {
			FileReader fr = new FileReader(fi);
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
	
	public static String GenQuery(String s) {
		String MaHocVien = s.substring(0, 10);
		String TenHocVien = s.substring(10, 60);
		for (int i = TenHocVien.length() - 1; i > 0; i--) {
			if (TenHocVien.charAt(i) != ' ') {
				TenHocVien = TenHocVien.substring(0, i+1);
				break;
			}
		}
		String NgaySinh = s.substring(66, 70) + s.substring(63, 65) + s.substring(60, 62);
		String GioiTinh = s.substring(70, 73);
		String DiemThi = s.substring(73, 77);
		return "insert HOCVIEN values ('" + MaHocVien + "', '" + TenHocVien + "', '" + NgaySinh + "', '" + GioiTinh + "', " + DiemThi + ")";
	}
	
	
	public static void Check() {
		boolean IsTrue = true;
		try {
			FileWriter fw = new FileWriter(fo);
			for (int i = 0; i < data.size(); i++) {
				boolean IsNameTrue = false;
				String s = data.get(i);
				String MaHocVien = s.substring(0, 10);
				String TenHocVien = s.substring(10, 60);
				String NgaySinh = s.substring(60, 70);
				String DiemThi = s.substring(73, 77);
				try {
					if ((MaHocVien.charAt(0) < 65 || MaHocVien.charAt(0) > 90) || (MaHocVien.charAt(1) < 65 || MaHocVien.charAt(1) > 90) ) {
						IsTrue = false;
						throw new Exception("Dong " + (i+1) + ": Sai dinh dang ma hoc vien\n");
					}
					for (int j = 2; j < 10; j++) {
						if (MaHocVien.charAt(j) < 48 || MaHocVien.charAt(j) > 57) {
							IsTrue = false;
							throw new Exception("Dong " + (i+1) + ": Sai dinh dang ma hoc vien\n");
						}
					}
				} catch (Exception e) {
					fw.write(e.getMessage());
				}
				for (int j = 0; j < TenHocVien.length(); j++) {
					if (TenHocVien.charAt(j) != ' ') {
						IsNameTrue = true;
						break;
					}
				}
				if (!IsNameTrue) {
					fw.write("Dong " + (i+1) + ": Ten hoc sinh rong\n");
					IsTrue = false;
				}
				try {
					for (int j = 0; j < NgaySinh.length(); j++) {
						if (j == 2 || j == 5) {
							if (NgaySinh.charAt(j) != '/' || NgaySinh.charAt(j) != '/') {
								IsTrue = false;
								throw new Exception("Dong " + (i+1) + ": Sai dinh dang ngay sinh\n");
							}
						}
						else {
							if (NgaySinh.charAt(j) < 48 || NgaySinh.charAt(j) > 57) {
								IsTrue = false;
								throw new Exception("Dong " + (i+1) + ": Sai dinh dang ngay sinh\n");
							}
						}
					}
					String Ngay = s.substring(60, 62);
					String Thang = s.substring(63, 65);
					if (Integer.parseInt(Ngay) > 31 || Integer.parseInt(Ngay) < 0) {
						IsTrue = false;
						throw new Exception("Dong " + (i+1) + ": Sai dinh dang ngay sinh\n");
					}
					if (Integer.parseInt(Thang) > 12 || Integer.parseInt(Thang) < 0) {
						IsTrue = false;
						throw new Exception("Dong " + (i+1) + ": Sai dinh dang ngay sinh\n");
					}
				} catch (Exception e) {
					fw.write(e.getMessage());
				}
				for (int j = 0; j < DiemThi.length(); j++) {
					if ((DiemThi.charAt(j) < 48 || DiemThi.charAt(j) > 57) && DiemThi.charAt(j) != '.') {
						fw.write("Dong " + (i+1) + ": Sai dinh dang diem\n");
						IsTrue = false;
					}
				}
//				if (Float.parseFloat(DiemThi) > 10.0 || Float.parseFloat(DiemThi) < 0.0) {
//					fw.write("Dong " + (i+1) + ": Sai dinh dang diem\n");
//					IsTrue = false;
//				}
				if (IsTrue) {
					Statement stmt = con.createStatement();
					stmt.executeUpdate(GenQuery(s));
					stmt.close();
					System.out.println("Them vao database thanh cong.");
				}
			}
			fw.close();
		} catch (Exception ex) {
			System.out.print("Error: " + ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		ConnectDB();
		DocFile();
		Check();
	}

}
