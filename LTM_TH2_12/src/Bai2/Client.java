package Bai2;

import java.awt.*;
import java.net.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class Client extends JFrame {

	private JPanel contentPane;
	private static JTextArea textArea = new JTextArea();

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
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("localhost");
		byte[] sendData = new byte[10000];
		byte[] receiveData = new byte[10000];
		Random generator = new Random();
		while(true) {
			int n = generator.nextInt(1000) + 1;
			String s = Integer.toString(n);
			textArea.append(s + "\n");
			sendData = s.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String str = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			if (str.equals("stop") == true) {
				textArea.append("stop\n");
				clientSocket.close();
				break;
			}
			TimeUnit.MILLISECONDS.sleep(500);
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
		scrollPane.setBounds(10, 10, 416, 253);
		contentPane.add(scrollPane);
		
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
