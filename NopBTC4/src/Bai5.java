import java.awt.event.*;
import javax.swing.*;

public class Bai5 extends JFrame implements KeyListener {
	JLabel lb;
	
	public void GUI() {
		lb = new JLabel("Text here", JLabel.CENTER);
		add(lb);
		addKeyListener(this);
		setSize(200, 200);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		lb.setText(String.valueOf(e.getKeyChar()));
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public Bai5(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai5("Keypress");
	}
	
}
