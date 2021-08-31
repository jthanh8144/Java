import java.awt.*;
import java.awt.event.*;

public class Bai3 extends Frame implements ActionListener{
	Label lb1, lb2, lb3, lb4, lb;
	TextField txta, txtb, txtc;
	TextArea txtkq;
	Button tinh, reset, thoat;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		lb = new Label("Giai phuong trinh bac 2");
		lb1 = new Label("Nhap a:");
		lb2 = new Label("Nhap b:");
		lb3 = new Label("Nhap c:");
		lb4 = new Label("Ket qua:");
		
		txta = new TextField();
		txtb = new TextField();
		txtc = new TextField();
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
		pn2 = new Panel(new GridLayout(3, 2));
		pn3 = new Panel(new GridLayout(1, 2));
		pn4 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtc);
		
		pn3.add(lb4);
		pn3.add(txtkq);
		
		pn4.add(tinh);
		pn4.add(reset);
		pn4.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		add(pn);
		setSize(400, 400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tinh) {
			double a = Double.parseDouble(txta.getText());
			double b = Double.parseDouble(txtb.getText());
			double c = Double.parseDouble(txtc.getText());
			if (a == 0) 
			{
				txtkq.setText("Pt la pt bac 1 co nghiem \n\t x = "+ Double.toString(-c/b));
			}
			else
			{
				double delta = 0;
				delta = b*b - 4*a*c;
				if (delta < 0) txtkq.setText("Pt vo nghiem");
				if (delta == 0) 
				{
					txtkq.setText("Pt co nghiem kep \n\t x = "+ Double.toString(-b/(2*a)));
				}
				else
				{
					double x1 = (-b + Math.sqrt(delta)) / (2*a), x2 = (-b - Math.sqrt(delta)) / (2*a);
					txtkq.setText("Pt co 2 nghiem phan biet: \n\t x1 = " + Double.toString(x1) + "\n\t x2 = " + Double.toString(x2));
				}
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
	public Bai3(String st) {
		super(st);
		GUI();
	}
	public static void main(String[] args) {
		new Bai3("Giai phuong trinh bac 2");
	}
}
