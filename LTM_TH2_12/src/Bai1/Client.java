package Bai1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKq;
	private JComboBox<String> comboBox;
	private JButton btnEqual;
	
	static Socket socket;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Kết nối thành công!\n");
		} catch (Exception ex) {
			System.out.println("Kết nối thất bại!\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEqual) {
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String a = txtA.getText();
				String b = txtB.getText();
				String o = (String) comboBox.getSelectedItem();
				dos.writeUTF(a);
				dos.flush();
				dos.writeUTF(b);
				dos.flush();
				dos.writeUTF(o);
				dos.flush();
				String result = din.readUTF();
				txtKq.setText(result);
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
	}

	public Client() {
		setTitle("B\u00E0i 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtA = new JTextField();
		txtA.setBounds(41, 33, 74, 19);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(223, 33, 74, 19);
		contentPane.add(txtB);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"+", "-", "*", "/"}));
		comboBox.setBounds(144, 32, 47, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("a");
		lblNewLabel.setBounds(72, 10, 20, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblB = new JLabel("b");
		lblB.setBounds(256, 10, 20, 13);
		contentPane.add(lblB);
		
		txtKq = new JTextField();
		txtKq.setBounds(96, 83, 295, 19);
		contentPane.add(txtKq);
		txtKq.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1.setBounds(41, 86, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		btnEqual = new JButton("=");
		btnEqual.setBounds(326, 32, 65, 21);
		contentPane.add(btnEqual);
		
		btnEqual.addActionListener(this);
	}
}
