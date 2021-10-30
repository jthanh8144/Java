package TCP;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai1_TCP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtString;
	JButton btnSend = new JButton("G\u1EEDi");
	static JTextArea textArea = new JTextArea();
	
	static Socket socket;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_TCP_C frame = new Bai1_TCP_C();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			socket = new Socket("localhost", 9999);
			textArea.setText("Kết nối thành công!\n");
		} catch (Exception ex) {
			textArea.setText("Kết nối thất bại!\n");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String st = txtString.getText();
				textArea.append("Chuỗi đã nhập: " + st + "\n");
				dos.writeUTF(st);
				dos.flush();
				st = din.readUTF();
				textArea.append(st);
				txtString.setText("");
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
	}
	
	public Bai1_TCP_C() {
		setTitle("Client chu\u1ED7i TCP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpChui = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNhpChui.setBounds(44, 14, 84, 13);
		contentPane.add(lblNhpChui);
		
		txtString = new JTextField();
		txtString.setColumns(10);
		txtString.setBounds(116, 11, 249, 19);
		contentPane.add(txtString);
		
		btnSend.setBounds(375, 10, 77, 21);
		contentPane.add(btnSend);
		textArea.setEditable(false);
		textArea.setBounds(0, 37, 504, 229);
		contentPane.add(textArea);
		btnSend.addActionListener(this);
	}
}
