import java.awt.*;
import java.awt.event.*;

public class Bai49 extends Frame implements ActionListener {
	Label lb1, lb2, lb;
	TextField txtn, txtkq;
	TextArea takq;
	Button tim, reset, thoat;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("In so nguyen to");
		lb1 = new Label("Nhap n:");
		lb2 = new Label("Ket qua:");
		
		txtn = new TextField();
		takq = new TextArea();
		
		tim = new Button("Tim");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		tim.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(2, 2));
		pn3 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txtn);
		pn2.add(lb2);
		pn2.add(takq);
		
		pn3.add(tim);
		pn3.add(reset);
		pn3.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		add(pn);
		setSize(400, 300);
		setVisible(true);
	}
	
	public boolean SNT(int m) {
		if (m < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(m); i++) {
			if (m % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tim) {
			String s = "";
			int n = Integer.parseInt(txtn.getText());
			if (n <= 0) {
				takq.setText("n > 0");
			}
			else {
				for (int i = 0; i <= n; i++) {
					if (SNT(i)) {
						s += (Integer.toString(i) + " ");
					}
				}
			}
			takq.setText(s);
		}
		if (e.getSource() == reset) {
			txtn.setText("");
			takq.setText("");
		}
		if (e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public Bai49(String st) {
		super(st);
		GUI();
	}
	public static void main(String[] args) {
		new Bai49("In so nguyen to");
	}
}
