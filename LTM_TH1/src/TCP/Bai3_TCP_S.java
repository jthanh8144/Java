package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class Bai3_TCP_S {
	private int port;
	public static ArrayList<Socket> listSK;

	public Bai3_TCP_S(int port) {
		this.port = port;
	}

	private void execute() throws IOException {
		ServerSocket server = new ServerSocket(port);
		WriteServer write = new WriteServer();
		write.start();
		System.out.println("Server is listening...");
		while (true) {
			Socket socket = server.accept();
			System.out.println("Đã kết nối với " + socket);
			Bai3_TCP_S.listSK.add(socket);
			ReadServer read = new ReadServer(socket);
			read.start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Bai3_TCP_S.listSK = new ArrayList<>();
		Bai3_TCP_S server = new Bai3_TCP_S(15797);
		server.execute();
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
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while (true) {
				String sms = dis.readUTF();
				if(sms.contains("exit")) {
					Bai3_TCP_S.listSK.remove(socket);
					System.out.println("Đã ngắt kết nối với " + socket);
					dis.close();
					socket.close();
					continue; //Ngắt kết nối rồi
				}
				for (Socket item : Bai3_TCP_S.listSK) {
					if(item.getPort() != socket.getPort()) {
						DataOutputStream dos = new DataOutputStream(item.getOutputStream());
						dos.writeUTF(sms);
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

class WriteServer extends Thread {

	@Override
	public void run() {
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			String sms = sc.nextLine();	//Đang đợi Server nhập dữ liệu
			try {
				for (Socket item : Bai3_TCP_S.listSK) {
					dos = new DataOutputStream(item.getOutputStream());
					dos.writeUTF("Server: " + sms);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}