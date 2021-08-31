import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;

public class Bai1_2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	JLabel lblNewLabel = new JLabel("Nh\u1EADp chu\u1ED7i");
	JLabel lblThcHin = new JLabel("Th\u1EF1c hi\u1EC7n");
	JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3");
	JTextField txt = new JTextField();
	JComboBox cbb = new JComboBox();
	JTextArea txtA = new JTextArea();
	JButton btnView = new JButton("View");
	JButton btnReset = new JButton("Reset");
	JButton btnExit = new JButton("Exit");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_2 frame = new Bai1_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnView) {
			txtA.setText("");
			if (cbb.getSelectedIndex() == 0) {
				int n = 1;
				String s = txt.getText().trim().replaceAll("( )+", " ");
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ' ') n++;
				}
				txtA.setText(Integer.toString(n));
			}
			if (cbb.getSelectedIndex() == 1) {
				Boolean isExist = false;
				List<String> list = new ArrayList<>();
				String[] l = txt.getText().trim().replaceAll("( )+", " ").split(" ");
				list.add(l[0]);
				for (int i = 1; i < l.length; i++) {
					isExist = false;
					for (String j : list) {
						if (j.equals(l[i])) {
							isExist = true;
							break;
						}
					}
					if (isExist == false) list.add(l[i]);
				}
				String t = txtA.getText();
				for (String i : list) {
					int temp = 0;
					for (String j : l) {
						if (j.equals(i)) {
							temp++;
						}
					}
					t += i + ": " + Integer.toString(temp) + " lần\n";
				}
				txtA.setText(t);
			}
			if (cbb.getSelectedIndex() == 2) {
				txtA.setText("");
				String[] l = txt.getText().trim().replaceAll("( )+", " ").split(" ");
				for (int i = l.length - 1; i >= 0; i--) {
					txtA.setText(txtA.getText() + l[i] + " ");
				}
			}
		}
		if (e.getSource() == btnReset) {
			txt.setText("");
			txtA.setText("");
		}
		if (e.getSource() == btnExit) {
			System.exit(0);
		}
	}
	
	public Bai1_2() {
		setResizable(false);
		setTitle("B\u00E0i 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setBounds(38, 34, 74, 19);
		contentPane.add(lblNewLabel);
		
		
		lblThcHin.setBounds(38, 70, 74, 19);
		contentPane.add(lblThcHin);
		
		lblKtQu.setBounds(38, 112, 74, 19);
		contentPane.add(lblKtQu);
		

		txt.setBounds(120, 34, 211, 19);
		contentPane.add(txt);
		txt.setColumns(10);

		
		cbb.setModel(new DefaultComboBoxModel(new String[] {"\u0110\u1EBFm t\u1EEB", "\u0110\u1EBFm t\u1EEB tr\u00F9ng l\u1EB7p", "\u0110\u1EA3o chu\u1ED7i"}));
		cbb.setBounds(122, 69, 136, 21);
		contentPane.add(cbb);
		
		txtA.setEnabled(false);
		txtA.setBounds(122, 109, 209, 110);
		contentPane.add(txtA);
		
		btnView.setBounds(38, 246, 85, 21);
		contentPane.add(btnView);
		
		btnReset.setBounds(150, 246, 85, 21);
		contentPane.add(btnReset);
		
		btnExit.setBounds(268, 246, 85, 21);
		contentPane.add(btnExit);
		
		btnView.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
	}
}
