import java.awt.*;
import java.awt.event.*;

public class Bai6 extends Frame implements ActionListener {
	Label lb1, lb2, lb3, lb;
	TextField txta, txtb, txtkq;
	Button tinh, reset, thoat;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Chuong trinh tinh tien Karaoke");
		lb1 = new Label("Nhap gio bat dau:");
		lb2 = new Label("Nhap gio bat dau:");
		lb3 = new Label("Ket qua:");
		
		txta = new TextField();
		txtb = new TextField();
		txtkq = new TextField();
		txtkq.enable(false);
		
		tinh = new Button("Tinh");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		tinh.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(3, 2));
		pn3 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtkq);
		
		pn3.add(tinh);
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
		if (e.getSource() == tinh) {
			int a = Integer.parseInt(txta.getText());
			int b = Integer.parseInt(txtb.getText());
			if (b-a < 18) {
				txtkq.setText(Integer.toString((b-a)*60000));
			}
			else {
				txtkq.setText(Integer.toString((b-a)*60000));
			}
		}
		if (e.getSource() == reset) {
			txta.setText("");
			txtb.setText("");
			txtkq.setText("");
		}
		if (e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public Bai6(String st) {
		super(st);
		GUI();
	}
	public static void main(String[] args) {
		new Bai6("Chuong trinh tinh tien Karaoke");
	}
}
