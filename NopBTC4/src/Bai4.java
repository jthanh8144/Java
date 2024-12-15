import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Bai4 extends JFrame implements ActionListener, ItemListener, ListSelectionListener  {
	JRadioButton rbtn;
	JCheckBox male, female;
	JList l;
	JComboBox c;
	JLabel lb;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		male = new JCheckBox("Male");
		female = new JCheckBox("Female");
		male.addItemListener(this);
		female.addItemListener(this);
		
		l = new JList(new String[] {"MS DOS", "Windows", "Linux"} );
		l.addListSelectionListener(this);
		
		c = new JComboBox();
		c.addItem("Tiger");
		c.addItem("Lion");
		c.addItem("Elephant");
		c.addItemListener(this);

		lb = new JLabel("Item is diplay here");
		
		pn = new Panel(new GridLayout(3, 1));
		pn1 = new Panel();
		pn2 = new Panel();
		pn3 = new Panel();
		pn3 = new Panel();
		
		pn1.add(male);
		pn1.add(female);
		pn1.add(c);
		
		pn2.add(l);
		
		pn3.add(lb);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		add(pn);
		setSize(400, 250);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		lb.setText("You choose " + l.getSelectedValue().toString() + " on list");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == c){
            lb.setText("You choose " + c.getSelectedItem().toString() + " on choice (combobox)");
        }
        if(e.getSource() == male){
            lb.setText("male selected!");
        }
        if(e.getSource() == female){
            lb.setText("female selected!");
        }
        if (e.getStateChange() == ItemEvent.DESELECTED) {
        	if(e.getSource() == male){
                lb.setText("male deselected!");
            }
            if(e.getSource() == female){
                lb.setText("female deselected!");
            }
        }
	}
	
	public Bai4(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai4("Minh hoa cac su kien");
	}
}
