package TCP;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai3_TCP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField textField;
	JButton btnSend;
	JTextArea textArea;

	class ReadClient extends Thread{
		private Socket client;

		public ReadClient(Socket client) {
			this.client = client;
		}
		
		public void run() {
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(client.getInputStream());
				while(true) {
					String sms = dis.readUTF();
					textArea.append(sms + "\n");
				}
			} catch (Exception e) {
				
			}
		}
	}

	class WriteClient extends Thread{
		private Socket client;
		private String name;

		public WriteClient(Socket client, String name) {
			this.client = client;
			this.name = name;
		}
		
		public void run() {
			DataOutputStream dos = null;
			try {
				dos = new DataOutputStream(client.getOutputStream());
				SendMessage(dos);
			} catch (Exception e) {
				try {
					dos.close();
					client.close();
				} catch (IOException ex) {
					System.out.println("Ngắt kết nối Server");
				}
			}
		}
		
	}

	static Socket client;
	static String name;
	
	private void execute() throws IOException {
		ReadClient read = new ReadClient(client);
		read.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend || e.getSource() == textField) {
			textArea.append("Tôi: " + textField.getText() + "\n");
			WriteClient write = new WriteClient(client, name);
			write.start();
		}
	}
	
	public static void main(String[] args) throws Exception {
		client = new Socket(InetAddress.getLocalHost(), 15797);
		name = JOptionPane.showInputDialog("Nhập tên của bạn");
		if (name.equals("")) {
			name = Integer.toString(client.getPort());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3_TCP_C frame = new Bai3_TCP_C();
					frame.setVisible(true);
					frame.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void SendMessage(DataOutputStream dos) throws Exception {
		dos.writeUTF(name + ": " + textField.getText());
		textField.setText("");
	}
	
	public Bai3_TCP_C() {
		setResizable(false);
		setTitle("Chat client TCP - User " + name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSend = new JButton("Gửi");
		btnSend.setBounds(351, 372, 85, 27);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setBounds(0, 374, 353, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 374);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btnSend.addActionListener(this);
		textField.addActionListener(this);
	}

}
