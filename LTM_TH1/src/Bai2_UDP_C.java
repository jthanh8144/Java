import java.awt.EventQueue;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai2_UDP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtPort;
	JTextField txtString;
	JButton btnSend = new JButton("Tính");
	JTextArea textArea = new JTextArea();
	
	static DatagramSocket clientSocket;
	static InetAddress IP;
	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai2_UDP_C frame = new Bai2_UDP_C();
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
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, Integer.parseInt(txtPort.getText()));
				clientSocket.send(sendPacket);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				String str = new String(receivePacket.getData());
				textArea.setText(str);
				clientSocket.close();
			} catch (Exception ex) {
				System.out.println("Error");
			}
		}
	}
	
	public Bai2_UDP_C() {
		setTitle("Client tính UDP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPort = new JTextField();
		txtPort.setBounds(169, 21, 153, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 hi\u1EC7u c\u1ED5ng");
		lblNewLabel.setBounds(37, 27, 122, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNhpChui = new JLabel("Nhập biểu thức");
		lblNhpChui.setBounds(37, 67, 111, 13);
		contentPane.add(lblNhpChui);
		
		txtString = new JTextField();
		txtString.setColumns(10);
		txtString.setBounds(169, 64, 153, 19);
		contentPane.add(txtString);
		txtString.setText("1+2*(4-2)-(5+(4/2+1))");
		
		btnSend.setBounds(332, 63, 77, 21);
		contentPane.add(btnSend);
		
		textArea.setEnabled(false);
		textArea.setBounds(0, 100, 504, 166);
		contentPane.add(textArea);
		btnSend.addActionListener(this);
	}
}
