import java.awt.*;
import java.awt.event.*;

public class Bai1 extends Frame implements ActionListener {
	Label lb1, lb2, lb3, lb4, lb;
	TextField txta, txtb, txtc, txtkq;
	Button run, reset, thoat;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Tim max 3 bien");
		lb1 = new Label("Nhap a:");
		lb2 = new Label("Nhap b:");
		lb3 = new Label("Nhap c:");
		lb4 = new Label("So lon nhat:");
		
		txta = new TextField();
		txtb = new TextField();
		txtc = new TextField();
		txtkq = new TextField();
		txtkq.enable(false);
		
		run = new Button("Run");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		run.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(4, 2));
		pn3 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtc);
		pn2.add(lb4);
		pn2.add(txtkq);
		
		pn3.add(run);
		pn3.add(reset);
		pn3.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		add(pn);
		setSize(400, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == run) {
			int a = Integer.parseInt(txta.getText());
			int b = Integer.parseInt(txtb.getText());
			int c = Integer.parseInt(txtc.getText());
			if (a > b) {
				if (a > c) txtkq.setText(Integer.toString(a));
				else txtkq.setText(Integer.toString(c));
			}
			else if (b > c) txtkq.setText(Integer.toString(b));
			else txtkq.setText(Integer.toString(c));
		}
		if (e.getSource() == reset) {
			txta.setText("");
			txtb.setText("");
			txtc.setText("");
			txtkq.setText("");
		}
		if (e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public Bai1(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai1("Tim max cua 3 so");
	}
}
