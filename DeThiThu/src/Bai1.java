import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai1 extends JFrame implements ActionListener {
	JLabel lb1, lb2, lb3, lb4;
	JTextField txt1, txt2, txt3, txt4;
	JButton btnDT, btnCV;
	JPanel pn;
	
	public void GUI() {
		lb1 = new JLabel("Do dai canh a", JLabel.RIGHT);
		lb2 = new JLabel("Do dai canh b", JLabel.RIGHT);
		lb3 = new JLabel("Do dai canh c", JLabel.RIGHT);
		lb4 = new JLabel("Ket qua", JLabel.RIGHT);
		
		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		txt4 = new JTextField(20);
		txt4.enable(false);
		
		btnDT = new JButton("Tinh dien tich");
		btnCV = new JButton("Tinh chu vi");
		
		pn = new JPanel();
        pn.setSize(400, 400);
        GridBagLayout layout = new GridBagLayout();
        pn.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pn.add(lb1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pn.add(new JLabel("     "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        pn.add(txt1, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        pn.add(new JLabel("     "), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pn.add(lb2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        pn.add(new JLabel("     "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        pn.add(txt2, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        pn.add(new JLabel("     "), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pn.add(lb3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        pn.add(new JLabel("     "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        pn.add(txt3, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        pn.add(new JLabel("     "), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 7;
        pn.add(btnDT, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        pn.add(new JLabel("     "), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 9;
        pn.add(btnCV, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        pn.add(new JLabel("     "), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        pn.add(lb4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 11;
        pn.add(new JLabel("     "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 11;
        pn.add(txt4, gbc);
        
        btnDT.addActionListener(this);
		btnCV.addActionListener(this);
                
        add(pn);
        setSize(400, 400);
		setVisible(true);
		setResizable(false);
	}
	
	public Double checkNumber(String s) throws Exception {
		for (int i =0; i < s.length(); i++) {
			if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != '.') {
				throw new Exception("Cac canh cua tam giac la so khong am");
			}
		}
		return Double.parseDouble(s);
	}
	public void checkTriangle(double a, double b, double c) throws Exception {
		if ((a < b + c) && (b < a + c) && (c < a + b)) {
			return;
		}
		else {
			throw new Exception("Ba so da nhap khong phai la tam giac");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCV) {
			try {
				double a = checkNumber(txt1.getText());
				double b = checkNumber(txt2.getText());
				double c = checkNumber(txt3.getText());
				checkTriangle(a, b, c);
				txt4.setText(Double.toString(a + b + c));
			} catch (Exception ee) {
				txt4.setText(ee.getMessage());
			}
		}
		if (e.getSource() == btnDT) {
			try {
				double a = checkNumber(txt1.getText());
				double b = checkNumber(txt2.getText());
				double c = checkNumber(txt3.getText());
				checkTriangle(a, b, c);
				double p = (a + b + c) / 2;
				txt4.setText(Double.toString(Math.sqrt(p*(p-a)*(p-b)*(p-c))));
			} catch (Exception ee) {
				txt4.setText(ee.getMessage());
			}
		}
	}
	
	public Bai1(String st) {
		super(st);
		GUI();
	}

	public static void main(String[] args) {
		new Bai1("Chu vi dien tich");
	}

}
