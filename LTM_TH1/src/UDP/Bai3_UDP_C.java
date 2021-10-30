package UDP;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai3_UDP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	class ReadClient extends Thread{
		private DatagramSocket client;

		public ReadClient(DatagramSocket client) {
			this.client = client;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					String sms = recieveData(client);
					textArea.append(sms + "\n");
				}
			} catch (Exception e) {
				
			}
		}
		
		private String recieveData(DatagramSocket client) throws IOException {
			byte[] temp = new byte[1024];
			DatagramPacket recieve_Packet = new DatagramPacket(temp, temp.length);
			client.receive(recieve_Packet);
			return new String(recieve_Packet.getData()).trim();
		}
	}

	class WriteClient extends Thread {
		private DatagramSocket client;
		private InetAddress host;
		private int port;
		private String name;
		
		public WriteClient(DatagramSocket client, InetAddress host, int port, String name) {
			this.client = client;
			this.host = host;
			this.port = port;
			this.name = name;
		}
		
		@Override
		public void run() {
			try {
				DatagramPacket DP = createPacket();
				client.send(DP);
			} catch (Exception e) {
				
			}
		}
	}
	
	private JPanel contentPane;
	JTextField textField;
	JTextArea textArea;
	JButton btnSend;

	private InetAddress host;
	private int port;
	static DatagramSocket client;
	static String name;
	private void execute() throws IOException {
		client.send(createPacket(name + " đã tham gia vào phòng chat!"));
		ReadClient read = new ReadClient(client);
		read.start();
	}
	
	public static void main(String[] args) throws Exception {
		client = new DatagramSocket();
		name = JOptionPane.showInputDialog("Nhập tên của bạn");
		if (name.equals("")) {
			name = Integer.toString(client.getLocalPort());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3_UDP_C frame = new Bai3_UDP_C(InetAddress.getLocalHost(), 1234);
					frame.setVisible(true);
					frame.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend || e.getSource() == textField) {
			textArea.append("Tôi: " + textField.getText() + "\n");
			WriteClient write = new WriteClient(client, host, port, name);
			write.start();
		}
	}
	
	private DatagramPacket createPacket(String value) {
		byte[] arrData = value.getBytes();
		return new DatagramPacket(arrData, arrData.length, host, port);
	}
	
	private DatagramPacket createPacket() {
		byte[] arrData = (name + ": " + textField.getText()).getBytes();
		textField.setText("");
		return new DatagramPacket(arrData, arrData.length, host, port);
	}

	public Bai3_UDP_C(InetAddress host, int port) {
		setResizable(false);
		setTitle("Client chat UDP - User " + name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(46, 91, 140, 101);
		
		textField = new JTextField();
		textField.setBounds(0, 384, 303, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnSend = new JButton("Gửi");
		btnSend.setBounds(301, 384, 85, 29);
		contentPane.add(btnSend);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 386, 384);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		scrollPane.setViewportView(textArea);
		
		btnSend.addActionListener(this);
		textField.addActionListener(this);

		this.host = host;
		this.port = port;
	}
}
