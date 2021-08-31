import java.awt.*;
import java.awt.event.*;

public class Bai4 extends Frame implements ActionListener {
	Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb;
	TextField txta, txtb, txtc, txtd, txte, txtf;
	TextArea txtkq;
	Button tinh, reset, thoat;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		lb = new Label("Tim max 3 bien");
		lb1 = new Label("Nhap a:");
		lb2 = new Label("Nhap b:");
		lb3 = new Label("Nhap c:");
		lb4 = new Label("Nhap d:");
		lb5 = new Label("Nhap e:");
		lb6 = new Label("Nhap f:");
		lb7 = new Label("Ket qua:");
		
		txta = new TextField();
		txtb = new TextField();
		txtc = new TextField();
		txtd = new TextField();
		txte = new TextField();
		txtf = new TextField();
		
		txtkq = new TextArea();
		txtkq.enable(false);
		
		tinh = new Button("Tinh");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		tinh.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(4, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(2, 6));
		pn3 = new Panel(new GridLayout(1, 2));
		pn4 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtc);
		pn2.add(lb4);
		pn2.add(txtd);
		pn2.add(lb5);
		pn2.add(txte);
		pn2.add(lb6);
		pn2.add(txtf);
		
		pn3.add(lb7);
		pn3.add(txtkq);
		
		pn4.add(tinh);
		pn4.add(reset);
		pn4.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		add(pn);
		setSize(400, 300);
		setVisible(true);
	}
	
	public boolean kt(double a, double b) {
		if (a/b == (int)a/b) return false;
		else return true;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tinh) {
			double a = Double.parseDouble(txta.getText());
			double b = Double.parseDouble(txtb.getText());
			double c = Double.parseDouble(txtc.getText());
			double d = Double.parseDouble(txtd.getText());
			double ee = Double.parseDouble(txte.getText());
			double f = Double.parseDouble(txtf.getText());
			double x = 0, y = 0;
			if (!kt(a, d) && !kt(b, ee)) {
				txtkq.setText("Loi!");
			}
			else {
				if (a != 0) 
				{
					y = (f - c*d/a) / (ee - b*d/a);
					x = (c - b*y)/a;
				}
				else
				{
					y = c/b;
					x = (f - ee*y)/d;
				}
				txtkq.setText("Pt la pt bac 1 co nghiem \n\t x = " + Double.toString(x) + "\n\t y = " + Double.toString(y));
			}
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
	
	public Bai4(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai4("Giai he phuong trinh bac nhat");
	}
}
