package Bai2_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class Client extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JTextArea textArea = new JTextArea();
	private JTextField textField;
	private JButton btnSend;
	
	static DatagramSocket clientSocket;
	static InetAddress IP;

	public static void main(String[] args) throws Exception {
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
		clientSocket = new DatagramSocket();
		IP = InetAddress.getByName("localhost");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			try {
				byte[] sendData = new byte[10000];
				byte[] receiveData = new byte[10000];
				sendData = textField.getText().getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
				clientSocket.send(sendPacket);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				String str = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
				if (str.equals("Chuỗi đã gửi không phải là số Fibonanci") == false) {
					clientSocket.close();
					btnSend.setEnabled(false);
				}
				textArea.append(str + "\n");
			} catch (Exception ex) {
				
			}
		}
		
	}
	
	public Client() {
		setTitle("B\u00E0i 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 416, 209);
		contentPane.add(scrollPane);
		
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(179, 20, 152, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 nguy\u00EAn d\u01B0\u01A1ng");
		lblNewLabel.setBounds(20, 25, 161, 13);
		contentPane.add(lblNewLabel);
		
		btnSend = new JButton("Ki\u1EC3m tra");
		btnSend.setBounds(341, 21, 85, 21);
		btnSend.addActionListener(this);
		contentPane.add(btnSend);
	}
}
