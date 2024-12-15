import java.awt.*;
import java.awt.event.*;

public class Bai412 extends Frame implements ActionListener {
	Button red, green, blue, exit;
	Panel pn1;
	
	public void GUI() {
		red = new Button("Do");
		green = new Button("Xanh la");
		blue = new Button("Xanh lam");
		exit = new Button("Exit");
		
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		exit.addActionListener(this);
		
		pn1 = new Panel();
		
		pn1.add(red);
		pn1.add(green);
		pn1.add(blue);
		pn1.add(exit);
		
		add(pn1, BorderLayout.SOUTH);
		setSize(300, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == red) {
			this.setBackground(Color.red);
			pn1.setBackground(Color.red);
		}
		if (e.getSource() == green) {
			this.setBackground(Color.green);
			pn1.setBackground(Color.green);
		}
		if (e.getSource() == blue) {
			this.setBackground(Color.blue);
			pn1.setBackground(Color.blue);
		}
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
	
	public Bai412(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai412("Doi mau nen");
	}
}
