import java.awt.*;
import java.awt.event.*;

public class Bai413 extends Frame implements ActionListener, ItemListener {
	CheckboxGroup gender;
	Checkbox male, female;
	List l;
	Choice c;
	Label lb;
	Button exit;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		gender = new CheckboxGroup();
		male = new Checkbox("Male", gender, true);
		female = new Checkbox("Female", gender, false);
		male.addItemListener(this);
		female.addItemListener(this);
		
		l = new List(3);
		l.add("MS DOS");
		l.add("Windows");
		l.add("Linux");
		l.addItemListener(this);
		
		c = new Choice();
		c.add("Tiger");
		c.add("Lion");
		c.add("Elephant");
		c.addItemListener(this);

		lb = new Label("Item is diplay here");
		
		exit = new Button("Exit");
		exit.addActionListener(this);
		
		pn = new Panel(new GridLayout(4, 1));
		pn1 = new Panel();
		pn2 = new Panel();
		pn3 = new Panel();
		pn3 = new Panel();
		pn4 = new Panel();
		
		pn1.add(male);
		pn1.add(female);
		
		pn2.add(l);
		
		pn3.add(c);
		
		pn4.add(lb);
		pn4.add(exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		add(pn);
		setSize(400, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == c){
            lb.setText(c.getSelectedItem());
        }
        if(e.getSource() == l)
        {
            lb.setText(l.getSelectedItem());
        }
        if(e.getSource() == male){
            lb.setText("male selected!");
        }
        if(e.getSource() == female){
            lb.setText("female selected!");
        }
	}
	
	public Bai413(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai413("Minh hoa cac su kien");
	}
}
