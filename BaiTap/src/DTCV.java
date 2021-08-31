import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DTCV  extends JFrame implements ActionListener {
	JLabel lb, lb1, lb2, lb3, lb4;
	JTextField txt1, txt2, txt3, txt4;
	JButton btnDT, btnCV, btnReset, btnExit;
	JPanel pn, pn1, pn2, pn3, pn4, pn5;
	
	public void GUI() {
		lb = new JLabel("Tinh chu vi dien tich");
		lb1 = new JLabel("Do dai a");
		lb2 = new JLabel("Do dai b");
		lb3 = new JLabel("Do dai c");
		lb4 = new JLabel("Ket thuc");
		
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt3 = new JTextField();
		txt4 = new JTextField();
		txt4.enable(false);
		
		btnDT = new JButton("Tinh dien tich");
		btnCV = new JButton("Tinh chu vi");
		btnReset = new JButton("Reset");
		btnExit = new JButton("Exit");
		
		pn1 = new JPanel(new FlowLayout());
		pn1.add(lb);
		
		pn2 = new JPanel(new GridLayout(3, 2));
		pn2.add(lb1);
		pn2.add(txt1);
		pn2.add(lb2);
		pn2.add(txt2);
		pn2.add(lb3);
		pn2.add(txt3);
		
		pn3 = new JPanel();
		pn3.add(btnDT);
		pn3.add(btnCV);
		
		pn4 = new JPanel(new GridLayout(1, 2));
		pn4.add(lb4);
		pn4.add(txt4);
		
		pn5 = new JPanel();
		pn5.add(btnReset);
		pn5.add(btnExit);
		
		pn = new JPanel();
		BoxLayout boxlayout = new BoxLayout(pn, BoxLayout.Y_AXIS);
		pn.setLayout(boxlayout);
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn.add(pn5);
		
		btnDT.addActionListener(this);
		btnCV.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		add(pn);
		setSize(500, 300);
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
		if (e.getSource() == btnReset) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
		}
		if (e.getSource() == btnExit) {
			System.exit(0);
		}
		
	}
	
	public DTCV(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new DTCV("Chu vi dien tich");
	}
}
