import java.awt.event.*;
import javax.swing.*;

public class Bai6 extends JFrame implements MouseListener {
	public Bai6(String st) {
		super(st);
		addMouseListener(this);
		setSize(200, 200);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.isMetaDown()) {
			System.out.println("You right click the mouse at " + e.getX() + " " + e.getY());
		}
		else {
			System.out.println("You left click the mouse at " + e.getX() + " " + e.getY());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("You press the mouse at " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("You release the mouse at " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("You enter the mouse at " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("You exit the mouse at " + e.getX() + " " + e.getY());
	}
	
	public static void main(String[] args) {
		new Bai6("Mouse test");
	}
}
