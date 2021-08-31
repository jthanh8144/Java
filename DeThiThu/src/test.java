import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class test extends JFrame implements ActionListener {
	public class GoiY{
		public String Ten;
		public int SoLuong;
		public GoiY(String Ten, int SoLuong) {
			this.Ten = Ten;
			this.SoLuong = SoLuong;
		}
	}
	
	private static String url;
	private static Connection con;
	private static File f;
	private static List<String> data = new ArrayList<>();
	
	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("Import data");
	JLabel lblKeyword = new JLabel("Keyword");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JButton btnImport = new JButton("Import file");
	JButton btnSoLuong = new JButton("So luong");
	JButton btnTongTien = new JButton("Tong tien");
	JButton btnGoiY = new JButton("Goi y");
	JTextArea textArea = new JTextArea();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ConnectDB();
	}
	
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
	// D:/Java/dtest.txt
	public static void DocFile(String s) {
		try {
			f = new File(s);
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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImport) {
			DocFile(txt1.getText());
			for (String s : data) {
				textArea.setText(textArea.getText() + s + "\n");
				String[] info = s.trim().split(", ");
				String query = "insert into DonHang (TenMatHang, SoTien, TenNguoiMua) values ('";
				query += info[0] + "', " + info[1] + ", '" + info[2] + "')";
				try {
					Statement stmt = con.createStatement();
					stmt.executeUpdate(query);
					stmt.close();
				} 
				catch(Exception ex) {
					System.out.println("Error: " + ex);
				}
			}
		}
		if (e.getSource() == btnSoLuong) {
			int SoLuong = 0;
			String s = txt2.getText().trim();
			String qSL = "select count(*) as SL from DonHang where TenMatHang = '" + s + "'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(qSL);
				while (rs.next()) {
					SoLuong = rs.getInt("SL");
				}
			}
			catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
			if (SoLuong == 0) {
				textArea.setText("Khong tim thay mat hang nay!");
			}
			else {
				textArea.setText(Integer.toString(SoLuong));
			}
		}
		if (e.getSource() == btnTongTien) {
			int TongTien = 0;
			String s = txt2.getText().trim();
			String qSL = "select * from DonHang where TenNguoiMua = '" + s + "'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(qSL);
				while (rs.next()) {
					TongTien += rs.getInt("SoTien");
				}
			}
			catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
			if (TongTien == 0) {
				textArea.setText("Khong tim thay nguoi mua nay!");
			}
			else {
				textArea.setText(Integer.toString(TongTien));
			}
		}
		if (e.getSource() == btnGoiY) {
			String s = txt2.getText().trim();
			List<String> listName = new ArrayList<>();
			List<String> listHang = new ArrayList<>();
			List<GoiY> list = new ArrayList<>();
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from DonHang where TenMatHang = '" + s + "'");
				while (rs.next()) {
					listName.add(rs.getString("TenNguoiMua"));
				}
				String query = "select * from DonHang where TenMatHang != '" + s + "' and (";
				for (String name : listName) {
					query += "TenNguoiMua = '" + name + "' or ";
				}
				query += "0 = 1)";
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					int index = listHang.indexOf(rs.getString("TenMatHang"));
					if (index == -1) {
						listHang.add(rs.getString("TenMatHang"));
						list.add(new GoiY(rs.getString("TenMatHang"), rs.getInt("SoTien")));
					}
					else {
						list.get(index).SoLuong += rs.getInt("SoTien");
					}
				}
				Collections.sort(list, new Comparator<GoiY>() {
					public int compare(GoiY a, GoiY b) {
						return a.SoLuong > b.SoLuong ? -1 : 1;
					}
				});
				textArea.setText("");
				for (GoiY item : list) {
					textArea.setText(textArea.getText() + item.Ten + ", " + item.SoLuong + "\n");
				}
			}
			catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
		}
	}

	public test() {
		setTitle("Quan li don hang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setBounds(74, 40, 76, 13);
		contentPane.add(lblNewLabel);

		lblKeyword.setBounds(74, 75, 76, 13);
		contentPane.add(lblKeyword);

		
		txt1.setBounds(171, 41, 110, 19);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2.setColumns(10);
		txt2.setBounds(171, 76, 201, 19);
		contentPane.add(txt2);
		
		btnImport.setBounds(291, 40, 85, 21);
		contentPane.add(btnImport);
		
		btnSoLuong.setBounds(74, 115, 85, 21);
		contentPane.add(btnSoLuong);
		
		btnTongTien.setBounds(181, 115, 85, 21);
		contentPane.add(btnTongTien);
		
		btnGoiY.setBounds(287, 115, 85, 21);
		contentPane.add(btnGoiY);
		
		textArea.setBounds(74, 164, 298, 154);
		contentPane.add(textArea);
		
		btnImport.addActionListener(this);
		btnSoLuong.addActionListener(this);
		btnTongTien.addActionListener(this);
		btnGoiY.addActionListener(this);
	}
}
