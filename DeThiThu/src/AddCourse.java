import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddCourse extends JFrame implements ActionListener {
	private static String url;
	private static Connection con;
	
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtCredit;
	JButton btnAdd = new JButton("Add");
	JButton btnClear = new JButton("Clear");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			ConnectDB();
			String code = txtCode.getText();
			String name = txtName.getText();
			String creditStr = txtCredit.getText();
			try {
				Statement stmt = con.createStatement();
				String query = "insert Courses values ('" + code + "', '" + name + "', " + creditStr + ")";
				stmt.executeUpdate(query);
				stmt.close();
				System.out.println("Them vao database thanh cong.");
			}
			catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
		}
		if (e.getSource() == btnClear) {
			txtCode.setText("");
			txtName.setText("");
			txtCredit.setText("");
		}
	}

	/**
	 * Create the frame.
	 */
	public AddCourse() {
		setResizable(false);
		setTitle("Add course");
		setDefaultCloseOperation(AddCourse.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setBounds(49, 46, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 82, 45, 13);
		contentPane.add(lblName);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(49, 122, 45, 13);
		contentPane.add(lblCredit);
		
		btnAdd.setBounds(61, 183, 85, 21);
		contentPane.add(btnAdd);

		btnClear.setBounds(212, 183, 85, 21);
		contentPane.add(btnClear);
		
		txtCode = new JTextField();
		txtCode.setBounds(104, 43, 226, 19);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(104, 79, 226, 19);
		contentPane.add(txtName);
		
		txtCredit = new JTextField();
		txtCredit.setColumns(10);
		txtCredit.setBounds(104, 119, 226, 19);
		contentPane.add(txtCredit);
		
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
	}

	
}
