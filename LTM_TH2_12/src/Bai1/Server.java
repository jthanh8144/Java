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
				String st = din.readUTF();
				dos.writeUTF(calculate(st));
				dos.flush();
			}
		} catch (Exception ex) {
			System.out.println("Ngắt kết nối");
		}
	}
	public static String calculate(String st) {
		String[] items = st.split("\\s");
		double A = Double.parseDouble(items[0]);
		double B = Double.parseDouble(items[2]);
		double result = 0;
		switch (items[1]) {
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
		default:
			return "error";
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
