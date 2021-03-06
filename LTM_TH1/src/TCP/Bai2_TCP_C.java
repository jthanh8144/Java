package TCP;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai2_TCP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtPort;
	JTextField txtString;
	JButton btnConnect = new JButton("K\u1EBFt n\u1ED1i");
	JButton btnSend = new JButton("Tính");
	JButton btnClose;
	JTextArea textArea = new JTextArea();
	
	Socket socket;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai2_TCP_C frame = new Bai2_TCP_C();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConnect) {
			try {
				socket = new Socket("localhost", Integer.parseInt(txtPort.getText()));
				textArea.setText("Kết nối thành công!\n");
				btnConnect.setEnabled(false);
				btnClose.setEnabled(true);
			} catch (Exception ex) {
				textArea.setText("Kết nối thất bại!\n");
			}
			
		}
		if (e.getSource() == btnSend) {
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String st = txtString.getText();
				textArea.append("Phép tính: " + st + "\n");
				dos.writeUTF(st);
				dos.flush();
				st = din.readUTF();
				textArea.append(st + "\n");
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
		if (e.getSource() == btnClose) {
			try {
				textArea.append("Đã ngắt kết nối!\n");
				socket.close();
			} catch (Exception ex) {
				
			}
		}
	}
	
	public Bai2_TCP_C() {
		setResizable(false);
		setTitle("Client tính TCP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPort = new JTextField();
		txtPort.setBounds(157, 21, 140, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 hi\u1EC7u c\u1ED5ng");
		lblNewLabel.setBounds(36, 28, 122, 13);
		contentPane.add(lblNewLabel);
		
		btnConnect.setBounds(307, 20, 77, 21);
		contentPane.add(btnConnect);
		
		JLabel lblNhpChui = new JLabel("Nhập biểu thức");
		lblNhpChui.setBounds(36, 67, 105, 13);
		contentPane.add(lblNhpChui);
		
		txtString = new JTextField();
		txtString.setColumns(10);
		txtString.setBounds(157, 64, 140, 19);
		contentPane.add(txtString);
		txtString.setText("1+2*(4-2)-(5+(4/2+1))");
		
		btnSend.setBounds(307, 63, 77, 21);
		contentPane.add(btnSend);
		textArea.setEditable(false);
		textArea.setBounds(0, 100, 504, 166);
		contentPane.add(textArea);
		
		btnClose = new JButton("Đóng");
		btnClose.setEnabled(false);
		btnClose.setBounds(394, 20, 77, 21);
		contentPane.add(btnClose);
		
		btnConnect.addActionListener(this);
		btnSend.addActionListener(this);
	}
}
