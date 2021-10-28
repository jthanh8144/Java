import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bai1_TCP_C extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtPort;
	JTextField txtString;
	JButton btnConnect = new JButton("K\u1EBFt n\u1ED1i");
	JButton btnSend = new JButton("G\u1EEDi");
	JTextArea textArea = new JTextArea();
	
	Socket socket;
	
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
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConnect) {
			try {
				socket = new Socket("localhost", Integer.parseInt(txtPort.getText()));
				textArea.setText("Kết nối thành công!\n");
			} catch (Exception ex) {
				textArea.setText("Kết nối thất bại!\n");
			}
			
		}
		if (e.getSource() == btnSend) {
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String st = txtString.getText();
				dos.writeUTF(st);
				dos.flush();
				st = din.readUTF();
				textArea.setText(textArea.getText() + st);
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
		
		txtPort = new JTextField();
		txtPort.setBounds(216, 21, 106, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 hi\u1EC7u c\u1ED5ng");
		lblNewLabel.setBounds(61, 28, 122, 13);
		contentPane.add(lblNewLabel);
		
		btnConnect.setBounds(332, 20, 77, 21);
		contentPane.add(btnConnect);
		
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
		
		btnConnect.addActionListener(this);
		btnSend.addActionListener(this);
	}
}
