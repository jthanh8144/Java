package Bai2_2;

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
				String send = "Chuỗi đã gửi không phải là số Fibonanci";
				int n = CheckFibo(receive);
				if (n != -1) {
					send = "Chuỗi là số Fibonanci thứ " + n;
				}
				sendData = send.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
				serverSocket.send(sendPacket);
			}
			
		} catch (Exception ex) {
			System.out.print("error");
		}
	}
	
	public static int CheckFibo(String s) {
		int n = Integer.parseInt(s);
		if (n == 1) return 1;
		int index = 2;
		int f1 = 1, f2 = 1, f = 0;
		do {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
			index++;
		} while (f < n);
		if (n != f) {
			return -1;
		} else {
			return index;
		}
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
