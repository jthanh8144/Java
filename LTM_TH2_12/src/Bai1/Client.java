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
	private JTextField txt;
	private JTextField txtKq;
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
				String st = txt.getText();
				dos.writeUTF(st);
				dos.flush();
				dos.flush();
				String result = din.readUTF();
				txtKq.setText(result);
				socket.close();
			} catch (Exception ex) {
				System.out.println("error");
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
		
		txt = new JTextField();
		txt.setBounds(144, 33, 172, 19);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập biểu thức");
		lblNewLabel.setBounds(41, 36, 117, 13);
		contentPane.add(lblNewLabel);
		
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
