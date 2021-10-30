package UDP;

import java.awt.EventQueue;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai1_UDP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtString;
	JButton btnSend = new JButton("G\u1EEDi");
	JTextArea textArea = new JTextArea();
	
	static DatagramSocket clientSocket;
	static InetAddress IP;
	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_UDP_C frame = new Bai1_UDP_C();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		clientSocket = new DatagramSocket();
		IP = InetAddress.getByName("localhost");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			try {
				byte[] sendData = new byte[1024];
				byte[] receiveData = new byte[10000];
				sendData = txtString.getText().getBytes();
				textArea.append("Chuỗi đã nhập: " + txtString.getText() + "\n");
				txtString.setText("");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9999);
				clientSocket.send(sendPacket);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				String str = new String(receivePacket.getData());
				textArea.append(str + "\n");
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
	}
	
	public Bai1_UDP_C() {
		setTitle("Client chuỗi UDP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpChui = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNhpChui.setBounds(30, 14, 84, 13);
		contentPane.add(lblNhpChui);
		
		txtString = new JTextField();
		txtString.setColumns(10);
		txtString.setBounds(111, 11, 269, 19);
		contentPane.add(txtString);
		
		btnSend.setBounds(401, 10, 77, 21);
		contentPane.add(btnSend);
		textArea.setEditable(false);
		textArea.setBounds(0, 37, 504, 229);
		contentPane.add(textArea);
		btnSend.addActionListener(this);
	}
}
