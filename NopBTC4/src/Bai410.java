import java.awt.*;
import java.awt.event.*;

public class Bai410 extends Frame implements ActionListener {
	Label lb1, lb2, lb;
	TextField txta, txtkq;
	Button ok, reset, thoat;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Kiem tra so fibonanci");
		lb1 = new Label("Nhap a:");
		lb2 = new Label("Ket qua:");
		
		txta = new TextField();
		txtkq = new TextField();
		
		ok = new Button("Ok");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		ok.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(2, 2));
		pn3 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtkq);
		
		pn3.add(ok);
		pn3.add(reset);
		pn3.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		add(pn);
		setSize(400, 200);
		setVisible(true);
	}
	
	public boolean Fibo(int n) {
		int a = 1, b = 1, t = 0;
		if (n == 1) return true;
		while (t < n)
		{
			t = a + b;
			a = b;
			b = t;
		}
		if (b == n) return true;
		else return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			int n = Integer.parseInt(txta.getText());
			if (n <= 0) {
				txtkq.setText("n > 0");
			}
			else {
				if (Fibo(n)) {
					txtkq.setText(n + " thuoc day fibo");
				}
				else {
					txtkq.setText(n + " khong thuoc day fibo");
				}
			}
			
		}
		if (e.getSource() == reset) {
			txta.setText("");
			txtkq.setText("");
		}
		if (e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public Bai410(String st) {
		super(st);
		GUI();
	}
	public static void main(String[] args) {
		new Bai410("Kiem tra so fibonanci");
	}
}
