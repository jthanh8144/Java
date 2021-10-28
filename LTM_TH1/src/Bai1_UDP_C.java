import java.awt.EventQueue;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai1_UDP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtPort;
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
	
	public Bai1_UDP_C() {
		setTitle("Client chuỗi UDP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPort = new JTextField();
		txtPort.setBounds(216, 21, 106, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 hi\u1EC7u c\u1ED5ng");
		lblNewLabel.setBounds(61, 28, 122, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNhpChui = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNhpChui.setBounds(99, 67, 84, 13);
		contentPane.add(lblNhpChui);
		
		txtString = new JTextField();
		txtString.setColumns(10);
		txtString.setBounds(216, 64, 106, 19);
		contentPane.add(txtString);
		
		btnSend.setBounds(332, 63, 77, 21);
		contentPane.add(btnSend);
		
		textArea.setEnabled(false);
		textArea.setBounds(0, 100, 504, 166);
		contentPane.add(textArea);
		btnSend.addActionListener(this);
	}
}
