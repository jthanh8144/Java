import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Bai2_TCP_S extends JFrame implements ActionListener {
	private int port;
	public static ArrayList<Socket> listSK;
	
	class Calculator {
		private boolean isError = false;
		private String varString[] = { "ans", "va", "vb", "vc", "vd", "ve", "vf" };
		private String constString[] = { "pi", "e" };
		public double var[] = new double[varString.length];
		private double cons[] = { Math.PI, Math.E };
		private boolean isDegOrRad = true;
		private int radix = 10, sizeRound = 10;

		public boolean isError() {
			return isError;
		}

		public void setError(boolean isError) {
			this.isError = isError;
		}

		public int getSizeRound() {
			return sizeRound;
		}

		public void setSizeRound(int sizeRound) {
			this.sizeRound = sizeRound;
		}

		public int getRadix() {
			return radix;
		}

		public void setRadix(int radix) {
			this.radix = radix;
		}

		public boolean isDegOrRad() {
			return isDegOrRad;
		}

		public void setDegOrRad(boolean isDegOrRad) {
			this.isDegOrRad = isDegOrRad;
		}

		protected boolean isIntegerNumber(double num) {
			long a = (long) num;
			if (a == num) {
				return true;
			}
			return false;
		}

		private String myRound(double num, int size) {
			if (isIntegerNumber(num)) {
				return Long.toString((long) num);
			} else {
				int n = size - Long.toString((long) num).length();
				num = Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
				if (isIntegerNumber(num)) {
					return Long.toString((long) num);
				} else {
					return Double.toString(num);
				}
			}
		}
		
		protected boolean isNumber(String s) {
			return true;
		}

		private boolean isNumber(char c) {
			String numberChar = ".0123456789abcdef";
			int index = numberChar.indexOf(c);
			if (radix == 10 && index >= 0 && index <= 10) {
				return true;
			}
			return false;
		}

		private double stringToNumber(String s) {
			int index = indexVar(s);
			if (index >= 0) {
				return var[index];
			}
			index = indexConst(s);
			if (index >= 0) {
				return cons[index];
			}
			if (s.charAt(s.length() - 1) == '.') {
				isError = true;
				System.out.println("Error number have '.'");
				return -1;
			}
			try {
				return Double.parseDouble(s);
			} catch (Exception e) {
				isError = true;
				System.out.println("Error parse number");
			}
			return -1;
		}

		public String numberToString(double num, int radix, int size) {
			return myRound(num, size);
		}

		private int indexVar(String s) {
			for (int i = 0; i < varString.length; i++) {
				if (s.equals(varString[i])) {
					return i;
				}
			}
			return -1;
		}

		private int indexConst(String s) {
			for (int i = 0; i < constString.length; i++) {
				if (s.equals(constString[i])) {
					return i;
				}
			}
			return -1;
		}

		private boolean isVarOrConst(String s) {
			if (indexConst(s) >= 0 || indexVar(s) >= 0) {
				return true;
			}
			return false;
		}

		private boolean isOperator(String s) {
			String operator[] = { "+", "-", "*", "/", ")", "(", };
			Arrays.sort(operator);
			if (Arrays.binarySearch(operator, s) > -1) {
				return true;
			} else {
				return false;
			}
		}

		private int priority(String s) {
			int p = 1;
			if (s.equals("+") || s.equals("-")) {
				return p;
			}
			p++;
			if (s.equals("*") || s.equals("/")) {
				return p;
			}
			return 0;
		}

		private boolean isPostOperator(String s) {
			String postOperator[] = { "!" };
			for (int i = 0; i < postOperator.length; i++) {
				if (s.equals(postOperator[i])) {
					return true;
				}
			}
			return false;
		}

		private boolean isWord(char c1, char c2) {
			return false;
		}

		private boolean isWord(String s) {
			return false;
		}

		private String standardize(String s) {
			s = s.trim();
			s = s.replaceAll("\\s+", " ");
			return s;
		}

		private String[] trimString(String s) {
			String temp[] = s.split(" ");
			return temp;
		}
		
		private String standardizeMath(String[] s) { // chuan hoa bieu thuc
			String s1 = "";

			int open = 0, close = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("(")) {
					open++;
				} else if (s[i].equals(")")) {
					close++;
				}
			}

			for (int i = 0; i < s.length; i++) {
				if (i > 0 && isPostOperator(s[i - 1]) && isNumber(s[i])) {
					s1 = s1 + "* ";
				}
				if ((i == 0 || (i > 0 && !isNumber(s[i - 1])
						&& !s[i - 1].equals(")") && !isPostOperator(s[i - 1])))
						&& (s[i].equals("+"))
						&& (isNumber(s[i + 1]) || s[i + 1].equals("+"))) {
					continue;
				}
				if ((i == 0 || (i > 0 && !isNumber(s[i - 1])
						&& !s[i - 1].equals(")") && !isPostOperator(s[i - 1])))
						&& (s[i].equals("-"))
						&& (isNumber(s[i + 1]) || s[i + 1].equals("-"))) {
					s1 = s1 + "~ ";
				}
				else if (i > 0
						&& ((isNumber(s[i - 1]) || s[i - 1].equals(")")) && isVarOrConst(s[i]))) {
					s1 = s1 + "* " + s[i] + " ";
				} else {
					s1 = s1 + s[i] + " ";
				}
			}

			for (int i = 0; i < (open - close); i++) {
				s1 += ") ";
			}
			return s1;
		}

		private String processInput(String sMath) {
			sMath = sMath.toLowerCase();
			sMath = standardize(sMath); // chuan hoa bieu thuc
			String s = "", temp = "";
			for (int i = 0; i < sMath.length(); i++) {
				if (!isNumber(sMath.charAt(i))
						|| (i < sMath.length() - 1 && isWord(sMath.charAt(i),
								sMath.charAt(i + 1)))) {
					s += " " + temp;
					temp = "" + sMath.charAt(i);
					if (isOperator(sMath.charAt(i) + "") && i < sMath.length() - 1
							&& !isWord(sMath.charAt(i), sMath.charAt(i + 1))) {
						s += " " + temp;
						temp = "";
					} else { 
						i++;
						while (i < sMath.length()
								&& !isNumber(sMath.charAt(i))
								&& (!isOperator(sMath.charAt(i) + ""))
								|| (i < sMath.length() - 1 && isWord(
										sMath.charAt(i - 1), sMath.charAt(i)))) {
							temp += sMath.charAt(i);
							i++;
							if (isWord(temp)) {
								s += " " + temp;
								temp = "";
								break;
							}
						}
						i--;
						s += " " + temp;
						temp = "";
					}
				} else {
					temp = temp + sMath.charAt(i);
				}
			}
			s += " " + temp;
			s = standardize(s);
			s = standardizeMath(trimString(s));
			return s;
		}

		private String postFix(String math) {
			String[] elementMath = trimString(math);

			String s1 = "";
			Stack<String> S = new Stack<String>();
			for (int i = 0; i < elementMath.length; i++) { 
				if (!isOperator(elementMath[i])) 
				{
					s1 = s1 + elementMath[i] + " "; 
				} else { // c la toan tu
					if (elementMath[i].equals("(")) {
						S.push(elementMath[i]); 
					} else {
						if (elementMath[i].equals(")")) { 
							String temp = "";
							do {
								temp = S.peek();
								if (!temp.equals("(")) {
									s1 = s1 + S.peek() + " ";
								}
								S.pop();
							} while (!temp.equals("("));
						} else {
							while (!S.isEmpty() && priority(S.peek()) >= priority(elementMath[i])) {
								s1 = s1 + S.pop() + " ";
							}
							S.push(elementMath[i]);
						}
					}
				}
			}
			while (!S.isEmpty()) {
				s1 = s1 + S.pop() + " ";
			}
			return s1;
		}

		public Double valueMath(String math) {
			math = processInput(math);
			math = postFix(math);
			String[] elementMath = trimString(math);
			Stack<Double> S = new Stack<Double>();
			double num = 0.0;
			double ans = 0.0;
			for (int i = 0; i < elementMath.length; i++) {
				if (!isOperator(elementMath[i])) {
					S.push(stringToNumber(elementMath[i]));
				} else { 
					if (S.isEmpty()) {
						System.out.println("Stack is empty ^^ ");
						isError = true;
						return 0.0;
					}
					double num1 = S.pop();
					String ei = elementMath[i];
					
					if (!S.empty()) {
						double num2 = S.peek();
						if (ei.equals("+")) {
							num = num2 + num1;
							S.pop();
						} else if (ei.equals("-")) {
							num = num2 - num1;
							S.pop();
						} else if (ei.equals("*")) {
							num = num2 * num1;
							S.pop();
						} else if (ei.equals("/")) {
							if (num1 != 0) {
								num = num2 / num1;
							} else {
								isError = true;
								return 0.0;
							}
							S.pop();
						} 
					} else {
						System.out.println("Error stack empty");
						isError = true;
						return 0.0;
					}
					S.push(num);
				}
			}
			ans = S.pop();
			return ans;
		}
	}

	class ReadServer extends Thread {
		private Socket socket;

		public ReadServer(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				Calculator c = new Calculator();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				while (true) {
					String sms = dis.readUTF();
					if(sms.contains("exit")) {
						Bai2_TCP_S.listSK.remove(socket);
						System.out.println("Đã ngắt kết nối với " + socket);
						dis.close();
						socket.close();
						continue;
					}
					for (Socket item : Bai2_TCP_S.listSK) {
						if(item.getPort() == socket.getPort()) {
							DataOutputStream dos = new DataOutputStream(item.getOutputStream());
							dos.writeUTF("Ket qua: " + c.valueMath(sms));
							break;
						}
					}
					System.out.println(sms);
				}
			} catch (Exception e) {
				try {
					socket.close();
				} catch (IOException ex) {
					System.out.println("Ngắt kết nối Server");
				}
			}
		}
	}

	private JPanel contentPane;
	private JTextField textField;
	JButton btnNewButton;
	JTextArea textArea;
	JButton btnClose;
	
	ServerSocket server;
	
	private void execute() throws IOException {
		server = new ServerSocket(port);
		textArea.append("Server is listening...\n");
		while (true) {
			Socket socket = server.accept();
			textArea.append("Đã kết nối với " + socket + "\n");
			Bai2_TCP_S.listSK.add(socket);
			ReadServer read = new ReadServer(socket);
			read.start();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai2_TCP_S frame = new Bai2_TCP_S();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bai2_TCP_S() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 10, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(227, 9, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 62, 238, 164);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnClose = new JButton("Đóng");
		btnClose.setBounds(320, 81, 85, 21);
		contentPane.add(btnClose);
		
		btnNewButton.addActionListener(this);
		btnClose.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			this.port = Integer.parseInt(textField.getText());
			try {
				execute();
			} catch (IOException e1) {
				
			}
		}
		if (e.getSource() == btnClose) {
			
		}
	}
}
