import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChuyenDoiCoSo extends JFrame implements ActionListener {
	JLabel lb, lb1, lb2, lb3, lb4;
	JTextField txt1, txt2, txt3, txt4;
	JButton btnOK, btnReset, btnExit;
	JPanel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new JLabel("Xu li co so");
		lb1 = new JLabel("Nhap so nguyen duong");
		lb2 = new JLabel("Bieu dien nhi phan");
		lb3 = new JLabel("Bieu dien bat phan");
		lb4 = new JLabel("Bieu dien thap luc phan");
		
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt3 = new JTextField();
		txt4 = new JTextField();
		txt2.enable(false);
		txt3.enable(false);
		txt4.enable(false);
		
		btnOK = new JButton("OK");
		btnReset = new JButton("Reset");
		btnExit = new JButton("Exit");
		
		pn1 = new JPanel(new FlowLayout());
		pn1.add(lb);
		
		pn2 = new JPanel(new GridLayout(4, 2));
		pn2.add(lb1);
		pn2.add(txt1);
		pn2.add(lb2);
		pn2.add(txt2);
		pn2.add(lb3);
		pn2.add(txt3);
		pn2.add(lb4);
		pn2.add(txt4);
		
		pn3 = new JPanel();
		pn3.add(btnOK);
		pn3.add(btnReset);
		pn3.add(btnExit);
		
		pn = new JPanel();
		BoxLayout boxlayout = new BoxLayout(pn, BoxLayout.Y_AXIS);
		pn.setLayout(boxlayout);
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		
		btnOK.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		add(pn);
		setSize(400, 300);
		setVisible(true);
		setResizable(false);
	}
	
	public String DaoChuoi(String s) {
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}

	public String NhiPhan(int n) {
		String s = "";
		while (n/2 != 0) {
			s += Integer.toString(n%2);
			n /= 2;
		}
		s += Integer.toString(n%2);
		return DaoChuoi(s);
	}
	
	public String BatPhan(int n) {
		String s = "";
		while (n/8 != 0) {
			s += Integer.toString(n%8);
			n /= 8;
		}
		s += Integer.toString(n%8);
		return DaoChuoi(s);
	}
	
	public String ThapLucPhan(int n) {
		String s = "";
		while (n/16 != 0) {
			switch (n%16) {
				case 10: 
					s += 'A';
					break;
				case 11: 
					s += 'B';
					break;
				case 12:
					s += 'C';
					break;
				case 13:
					s += 'D';
					break;
				case 14:
					s += 'E';
					break;
				case 15:
					s += 'F';
					break;
				default:
					s += Integer.toString(n%16);
					break;
			}
			n /= 16;
		}
		switch (n%16) {
			case 10: 
				s += 'A';
				break;
			case 11: 
				s += 'B';
				break;
			case 12:
				s += 'C';
				break;
			case 13:
				s += 'D';
				break;
			case 14:
				s += 'E';
				break;
			case 15:
				s += 'F';
				break;
			default:
				s += Integer.toString(n%16);
				break;
		}
		return DaoChuoi(s);
	}
	
	public int checkPosInt(String s) throws Exception {
		for (int i =0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				throw new Exception("Vui long nhap so nguyen duong");
			}
		}
		int n = Integer.parseInt(s);
		if (n <= 0) {
			throw new Exception("Vui long nhap so nguyen duong");
		}
		return n;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			try {
				int n = checkPosInt(txt1.getText());
				txt2.setText(NhiPhan(n));
				txt3.setText(BatPhan(n));
				txt4.setText(ThapLucPhan(n));
			} catch (Exception ee) {
				txt1.setText(ee.getMessage());
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
	
	public ChuyenDoiCoSo(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new ChuyenDoiCoSo("Chuyen doi co so");
	}
}
