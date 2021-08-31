import java.awt.*;
import java.awt.event.*;

public class Bai3 extends Frame implements ActionListener {
	Label lb;
	TextField txt;
	List l;
	Button btn, exit;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Minh hoa cac su kien");
		txt = new TextField(25);
		l = new List(3);
		l.add("Tiger");
		l.add("Lion");
		l.add("Elephant");
		
		btn = new Button("OK");
		exit = new Button("Exit");
		
		btn.addActionListener(this);
		exit.addActionListener(this);
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new FlowLayout());
		pn3 = new Panel(new FlowLayout());
		
		pn1.add(btn);
//		pn1.add(txt);
//		pn1.add(l);
		
		pn2.add(lb);
		
		pn3.add(exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		add(pn);
		setSize(400, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			lb.setText("Ban da bam vao nut OK");
		}
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
	
	public Bai3(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai3("Minh hoa cac su kien");
	}
}
