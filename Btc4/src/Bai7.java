import java.awt.*;
import java.awt.event.*;

public class Bai7 extends Frame implements ActionListener {
	Label lb1, lb2, lb3, lb;
	TextField txta, txtb, txtkq;
	Button run, reset, thoat;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		lb = new Label("Tim so ngay cua thang");
		lb1 = new Label("Thang");
		lb2 = new Label("Nam");
		lb3 = new Label("Ket qua");
		
		txta = new TextField();
		txtb = new TextField();
		txtkq = new TextField();
		txtkq.enable(false);
		
		run = new Button("Run");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		
		run.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(4, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(1, 6));
		pn3 = new Panel(new GridLayout(1, 2));
		pn4 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		
		pn3.add(lb3);
		pn3.add(txtkq);
		
		pn4.add(run);
		pn4.add(reset);
		pn4.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		add(pn);
		setSize(400, 160);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == run) {
			int month = Integer.parseInt(txta.getText());
			int year = Integer.parseInt(txtb.getText());
			if (year < 0)
			{
				txtkq.setText("Nam > 0");
			}
			else if (month < 0 || month > 12)
			{
				txtkq.setText("1 <= thang <= 12");
			}
			else if (month == 2) {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
					txtkq.setText("Thang 2 cua nam " + year + " co 29 ngay.");
				}
				else {
					txtkq.setText("Thang 2 cua nam " + year + " co 28 ngay.");
				}
			}
			else 
			{
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					txtkq.setText("Thang " + month + "cua nam " + year + " co 30 ngay.");
				}
				else {
					txtkq.setText("Thang " + month + "cua nam " + year + " co 31 ngay.");
				}
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
	
	public Bai7(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai7("Tim so ngay cua thang");
	}
}
