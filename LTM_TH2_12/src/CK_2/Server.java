package CK_2;

import java.net.*;

class ThreadSocket extends Thread {
	DatagramSocket serverSocket = null;
	public ThreadSocket(DatagramSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void run() {
		try {
			byte[] receiveData = new byte[10000];
			byte[] sendData = new byte[10000];
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				InetAddress IP = receivePacket.getAddress();
				int port = receivePacket.getPort();
				String receive = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
				sendData = check(receive).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
				serverSocket.send(sendPacket);
			}
			
		} catch (Exception ex) {
			
		}
	}
	
	public static String check(String s) {
		String t = "";
		for (int i = s.length() - 1; i >= 0 ; i--) {
			t += s.charAt(i);
		}
		if (s.equals(t) == true) {
			return "Chuỗi đã gửi là chuỗi đối xứng";
		}
		return "Chuỗi đã gửi không phải chuỗi đối xứng";
	}
}

public class Server {
	public static void main(String[] args) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Khởi chạy server thành công!");
		while (true) {
			new ThreadSocket(serverSocket).start();
		}
	}
}
