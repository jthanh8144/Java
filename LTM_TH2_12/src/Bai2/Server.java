package Bai2;

import java.net.*;

public class Server {
	public static boolean Check(String s) {
		int n = Integer.parseInt(s);
		/* int f1 = 1, f2 = 2, f = 0;
		do {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		} while (f < n);
		if (n != f) {
			return false;
		} else {
			return true;
		} */
		if (Math.sqrt(5*n*n + 4) == (int) Math.sqrt(5*n*n + 4) || Math.sqrt(5*n*n - 4) == (int) Math.sqrt(5*n*n - 4)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		byte[] receiveData = new byte[10000];
		byte[] sendData = new byte[10000];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			InetAddress IP = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String receive = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			String send = "";
			if (Check(receive) == true) {
				send = "stop";
			}
			sendData = send.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
			serverSocket.send(sendPacket);
		}
	}
}
