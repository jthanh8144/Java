import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextArea;

public class ListCourse extends JFrame {
	private static String url;
	private static Connection con;
	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCourse frame = new ListCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ListCourse listCourse = new ListCourse();
		listCourse.view();
		
	}
	
	public static void ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://ACERNITRO5:1433; DatabaseName=TestJava";
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("Ket noi csdl thanh cong.");
		}catch(Exception ex) {
			System.out.print("Connect fail: " + ex);
		}
	}
	
	public void view() {
		ConnectDB();
		textArea.setText("");
		try {
			String query = "select * from Courses";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				textArea.setText(textArea.getText() + rs.getString("Code") + " | " + rs.getString("CourseName") + " | " + rs.getInt("Credit") + "\n");
			}
			stmt.close();
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	/**
	 * Create the frame.
	 */
	public ListCourse() {
		setTitle("All courses");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List of all Courses (Order by credit)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 10, 345, 49);
		contentPane.add(lblNewLabel);
		
		textArea.setBounds(24, 69, 501, 275);
		contentPane.add(textArea);
		
		view();
	}
}
