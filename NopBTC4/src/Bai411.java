import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
 
public class Bai411 extends JFrame implements ActionListener{
	double a = 0, b = 0, temp = 0, result = 0;
	int operation = 0;
	boolean sttSqrt = false, sttEquals = false, sttPercent = false, sttMs = false;
	JLabel lb;
	JTextField txtkq, txt;
	JPanel pn, pn1, pn2, pn20, pn3, pn30, pn31, pn32;
	String btnName[] = {
			"MC", "MR", "MS", "M+",
			"Backspace", "CE", "C", 
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "*", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "=",
	};
	JButton btn;
	
	public JButton initBtn(String btnname)
	{
	     btn = new JButton(btnname);
	     btn.addActionListener(this);
	     return btn;
	}
	
	public void GUI() {
		lb = new JLabel("");
		txtkq = new JTextField(35);
		txtkq.setBounds(50, 50, 150, 20);
		txt = new JTextField();
		txt.enable(false);
		
		pn1 = new JPanel(new GridLayout(2, 1));
		pn1.add(lb);
		pn1.add(txtkq);
		pn1.setBorder(new EmptyBorder(new Insets(20, 0, 10, 0)));
		
		pn20 = new JPanel(new GridLayout(5, 1));
		pn20.add(txt);
		for (int i = 0; i < 4; i++) {
			pn20.add(initBtn(btnName[i]));
		}
		
		pn31 = new JPanel(new GridLayout(1, 3));
		for (int i = 4; i < 7; i++) {
			pn31.add(initBtn(btnName[i]));
		}
		
		pn32 = new JPanel(new GridLayout(4, 5));
		for (int i = 7; i < 27; i++) {
			pn32.add(initBtn(btnName[i]));
		}
		
		pn30 =  new JPanel();
		BoxLayout boxlayout = new BoxLayout(pn30, BoxLayout.Y_AXIS);
		pn30.setLayout(boxlayout);
		pn30.add(pn31);
		pn30.add(pn32);
		
		pn2 =  new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(pn2, BoxLayout.X_AXIS);
		pn2.setLayout(boxlayout1);
		pn20.setBorder(new EmptyBorder(new Insets(0, 0, 0, 10)));
		pn2.add(pn20);
		pn2.add(pn30);
		
		pn = new JPanel();
		pn.add(pn1);
		pn.add(pn2);
		add(pn);
		setSize(400, 280);
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "1":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "1");
				break;
			case "2":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "2");
				break;
			case "3":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "3");
				break;
			case "4":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "4");
				break;
			case "5":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "5");
				break;
			case "6":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "6");
				break;
			case "7":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "7");
				break;
			case "8":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "8");
				break;
			case "9":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "9");
				break;
			case "0":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + "0");
				break;
			case ".":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(txtkq.getText() + ".");
				break;
			case "%":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				temp = Double.parseDouble(txtkq.getText()) / 100;
				sttPercent = true;
				txtkq.setText(txtkq.getText() + "%");
				break;
			case "sqrt":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				lb.setText(lb.getText() + "sqrt(");
				sttSqrt = true;
				break;
			case "+/-":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText(Double.toString(-Double.parseDouble(txtkq.getText())));
				break;
			case "1/x":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				try {
					txtkq.setText(Double.toString(1 / Double.parseDouble(txtkq.getText())));
				}
				catch(Exception ex) {
				}
				break;
			case "Backspace":
				txtkq.setText(txtkq.getText().substring(0, txtkq.getText().length() - 1));
				break;
			case "CE":
				if (sttEquals) {
					lb.setText("");
					txtkq.setText("");
					sttEquals = false;
				}
				txtkq.setText("");
				break;
			case "C":
				txtkq.setText("");
				lb.setText("");
				a = 0;
				b = 0;
				break;
			case "M+":
				if (txtkq.getText() != "") {
					txt.setText("M+");
					result += Double.parseDouble(txtkq.getText());
				}
				break;
			case "MS":
				txt.setText("MS");
				if (!sttMs) {
					result = Double.parseDouble(txtkq.getText());
					sttMs = true;
				}
				else if (txtkq.getText() != "") {
					result -= Double.parseDouble(txtkq.getText());
				}
				break;
			case "MR":
				lb.setText("");
				txtkq.setText(Double.toString(result));
				result = 0;
				break;
			case "MC":
				lb.setText("");
				txtkq.setText(Double.toString(result));
				result = 0;
				break;
			case "+":
				if (txtkq.getText() == "") break;
				if (sttSqrt) {
					a = Math.sqrt(Double.parseDouble(txtkq.getText()));
					lb.setText(lb.getText() + txtkq.getText() + ") + ");
				}
				else if (sttPercent) {
					a = temp;
					sttPercent = false;
					lb.setText(txtkq.getText() + " + ");
				}
				else {
					a = Double.parseDouble(txtkq.getText());
					lb.setText(lb.getText() + txtkq.getText() + " + ");
				}
				txtkq.setText("");
				operation = 1;
				break;
			case "-":
				if (txtkq.getText() == "") break;
				if (sttSqrt) {
					a = Math.sqrt(Double.parseDouble(txtkq.getText()));
					lb.setText(lb.getText() + txtkq.getText() + ") - ");
				}
				else if (sttPercent) {
					a = temp;
					sttPercent = false;
					lb.setText(txtkq.getText() + " - ");
				}
				else {
					a = Double.parseDouble(txtkq.getText());
					lb.setText(txtkq.getText() + " - ");
				}
				txtkq.setText("");
				operation = 2;
				break;
			case "*":
				if (txtkq.getText() == "") break;
				if (sttSqrt) {
					a = Math.sqrt(Double.parseDouble(txtkq.getText()));
					lb.setText(lb.getText() + txtkq.getText() + ") * ");
				}
				else if (sttPercent) {
					a = temp;
					sttPercent = false;
					lb.setText(txtkq.getText() + " * ");
				}
				else {
					a = Double.parseDouble(txtkq.getText());
					lb.setText(txtkq.getText() + " * ");
				}
				txtkq.setText("");
				operation = 3;
				break;
			case "/":
				if (txtkq.getText() == "") break;
				if (sttSqrt) {
					a = Math.sqrt(Double.parseDouble(txtkq.getText()));
					lb.setText(lb.getText() + txtkq.getText() + ") / ");
				}
				else if (sttPercent) {
					a = temp;
					sttPercent = false;
					lb.setText(txtkq.getText() + " / ");
				}
				else {
					a = Double.parseDouble(txtkq.getText());
					lb.setText(txtkq.getText() + " / ");
				}
				txtkq.setText("");
				operation = 4;
				break;
			case "=":
				if (sttEquals) break;
				if (txtkq.getText() == "") break;
				if (sttSqrt) {
					b = Math.sqrt(Double.parseDouble(txtkq.getText()));
					lb.setText(lb.getText() + txtkq.getText() + ") = ");
				}
				else if (sttPercent) {
					b = temp;
					if (operation == 0) {
						a = temp;
						lb.setText(lb.getText() + txtkq.getText() + " = ");
						txtkq.setText(Double.toString(a));
						break;
					}
					sttPercent = false;
					lb.setText(lb.getText() + txtkq.getText() + " = ");
				}
				else {
					b = Double.parseDouble(txtkq.getText());
					lb.setText(lb.getText() + txtkq.getText() + " = ");
				}
				switch(operation) {
					case 1:
						txtkq.setText(Double.toString(a + b));
						break;
					case 2:
						txtkq.setText(Double.toString(a - b));
						break;
					case 3:
						txtkq.setText(Double.toString(a * b));
						break;
					case 4:
						txtkq.setText(Double.toString(a / b));
						break;
					default:
						if (sttSqrt) {
							a = Math.sqrt(Double.parseDouble(txtkq.getText()));
						}
						else {
							a = Double.parseDouble(txtkq.getText());
						}
						txtkq.setText(Double.toString(a));
						break;
				}
				operation = 0;
				sttEquals = true;
				break;
		}
	}
	
	public Bai411(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai411("Calculator");
	}
}