import java.awt.EventQueue;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class Bai1_UDP_ThreadSocket extends Thread {
	DatagramSocket serverSocket = null;
	public Bai1_UDP_ThreadSocket(DatagramSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void run() {
		try {
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[10000];
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				InetAddress IP = receivePacket.getAddress();
				int port = receivePacket.getPort();
				String st = new String(receivePacket.getData());
//				System.out.println("Chuoi: " + st);
				if (!st.trim().equals("")) {
					sendData = ("Chuoi hoa: " + ChuoiHoa(st) + "\nChuoi thuong: " + ChuoiThuong(st) + "\nChuoi HT: " + ChuoiHT(st) 
					+ "\nChuoi co " + DemTu(st) + " tu\nChuoi co " + DemNguyenAm(st) + " nguyen am").getBytes();
				} else {
					sendData = "Client sent a empty string!".getBytes();
				}
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
				serverSocket.send(sendPacket);
			}
		} catch (Exception ex) {
			
		}
	}
	
	public String ChuoiHoa(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiThuong(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiHT(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			} else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public int DemTu(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public int DemNguyenAm(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i' || s.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}
	
}

public class Bai1_UDP_S extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtPort;
	JButton btnRun = new JButton("Run");
	static JTextArea textArea = new JTextArea();
	
	DatagramSocket serverSocket;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRun) {
			try {
				serverSocket = new DatagramSocket(Integer.parseInt(txtPort.getText()));
				textArea.setText("Khởi chạy server thành công!");
				while (true) {
					new Bai1_UDP_ThreadSocket(serverSocket).start();
				}
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_UDP_S frame = new Bai1_UDP_S();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Bai1_UDP_S() {
		setTitle("Server chuỗi UDP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 hi\u1EC7u c\u1ED5ng");
		lblNewLabel.setBounds(41, 22, 115, 13);
		contentPane.add(lblNewLabel);
		
		txtPort = new JTextField();
		txtPort.setBounds(194, 19, 96, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		btnRun.setBounds(300, 18, 85, 21);
		contentPane.add(btnRun);
		
		textArea.setEnabled(false);
		textArea.setBounds(0, 48, 449, 215);
		contentPane.add(textArea);
		
		btnRun.addActionListener(this);
	}

}
