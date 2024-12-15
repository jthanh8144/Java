import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class Bai3 extends JFrame implements ActionListener  {
	JLabel lb1, lb2;
	JTextField txt1, txt2;
	JButton Submit, Reset, Cancel;
	JTable tbDaTa;
	JPanel pn1, pn11, pn12, pn2, pn;
	JScrollPane scrollPane;
	Vector vctHeader, vctData;
	
	public void GUI() {
		lb1 = new JLabel("Input information");
		lb2 = new JLabel("SQL");
		
		txt1 = new JTextField(25);
		txt2 = new JTextField(25);
		txt1.setText("jdbc:mysql://127.0.0.1:3306/DATA");
		txt2.setText("select * from Table1");
		
		tbDaTa = new JTable();
		
		Submit = new JButton("Submit");
		Reset = new JButton("Reset");
		Cancel = new JButton("Cancel");
		
		pn11 = new JPanel(new GridLayout(0, 1));
		pn11.add(lb1);
		pn11.add(lb2);
		
		pn12 = new JPanel(new GridLayout(0, 1));
		pn12.add(txt1);
		pn12.add(txt2);
		
		pn1 = new JPanel();
		pn1.add(pn11, BorderLayout.CENTER);
		pn1.add(pn12, BorderLayout.LINE_END);
		
		vctHeader = new Vector();
		vctHeader.add("Id");
		vctHeader.add("Name");
		vctHeader.add("Address");
		vctHeader.add("Total");
		scrollPane = new JScrollPane(tbDaTa);
		tbDaTa.setFillsViewportHeight(true);

		
		pn2 = new JPanel();
		pn2.add(Submit);
		pn2.add(Reset);
		pn2.add(Cancel);
		
		pn = new JPanel();
		BoxLayout boxlayout = new BoxLayout(pn, BoxLayout.Y_AXIS);
		pn.setLayout(boxlayout);
		pn.add(pn1);
		pn.add(scrollPane);
		pn.add(pn2);
		
		Submit.addActionListener(this);
		Reset.addActionListener(this);
		Cancel.addActionListener(this);
		
		add(pn);
		setSize(700, 400);
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Submit) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(txt1.getText());
				
				Statement stmt = con.createStatement();
				String sql = txt2.getText();
				ResultSet rs = stmt.executeQuery(sql);
				vctData = new Vector();
				while (rs.next()) {
					Vector row = new Vector();
					row.add(rs.getInt("ID"));
					row.add(rs.getString("Name"));
					row.add(rs.getString("Addresss"));
					row.add(rs.getDouble("Total"));
					vctData.add(row);
				}
				tbDaTa.setModel(new DefaultTableModel(vctData, vctHeader));
				rs.close();
				stmt.close();
			}catch(Exception ex) {
				System.out.print("Error" + ex);
			}
		}
		if (e.getSource() == Reset) {
			txt1.setText("");
			txt2.setText("");
			tbDaTa.setModel(new DefaultTableModel());
		}
		if (e.getSource() == Cancel) {
			System.exit(0);
		}
	}
	
	public Bai3(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai3("Database programing");
	}
}
