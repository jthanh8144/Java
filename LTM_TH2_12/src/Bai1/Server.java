package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	public static String calculate(String a, String b, String o) {
		double A = Double.parseDouble(a);
		double B = Double.parseDouble(b);
		double result = 0;
		switch (o) {
		case "+":
			result = A + B;
			break;
		case "-":
			result = A - B;
			break;
		case "*":
			result = A * B;
			break;
		case "/":
			result = A / B;
			break;
		}
		return Double.toString(result);
	}
	
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		while (true) {
			String a = din.readUTF();
			String b = din.readUTF();
			String o = din.readUTF();
			dos.writeUTF(calculate(a, b, o));
			dos.flush();
		}
	}
}
