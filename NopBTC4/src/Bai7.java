import java.awt.event.*;
import javax.swing.*;

public class Bai7 extends JFrame {
	JMenuBar m;
	JMenu f, e, sub;
	
	public void GUI() {
		setBounds(300, 200, 200, 200);
		m = new JMenuBar();
		setJMenuBar(m);
		
		f = new JMenu("File");
		f.add(new JMenuItem("New"));
		f.add(new JMenuItem("Open"));
		f.add(new JMenuItem("Exit"));
		
		e = new JMenu("Edit");
		e.add(new JMenuItem("Copy"));
		e.add(new JMenuItem("Cut"));
		e.add(new JMenuItem("Paste"));
		
		sub = new JMenu("Option");
		sub.add(new JMenuItem("First"));
		sub.add(new JMenuItem("Second"));
		sub.add(new JMenuItem("Thrid"));
		
		e.add(sub);
		e.add(new JCheckBoxMenuItem("Protected"));
		m.add(f);
		m.add(e);
		setSize(300, 200);
		setVisible(true);
	}
	
	public Bai7(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai7("Menubar test");
	}
}
