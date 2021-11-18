package Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadSocket extends Thread {
	Socket socket = null;
	public ThreadSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			while (true) {
				String a = din.readUTF();
				String b = din.readUTF();
				String o = din.readUTF();
				dos.writeUTF(calculate(a, b, o));
				dos.flush();
			}
		} catch (Exception ex) {
			System.out.println("Error");
		}
	}
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
}

public class Server {
	
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Server is started");
		while (true) {
			new ThreadSocket(server.accept()).start();
		}
	}
}
