package UDP;

import java.net.*;

class Bai1_UDP_ThreadSocket extends Thread {
	DatagramSocket serverSocket = null;
	public Bai1_UDP_ThreadSocket(DatagramSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void run() {
		try {
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[10000];
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				InetAddress IP = receivePacket.getAddress();
				int port = receivePacket.getPort();
				String st = new String(receivePacket.getData());
				if (!st.trim().equals("")) {
					sendData = ("Chuoi hoa: " + ChuoiHoa(st) + "\nChuoi thuong: " + ChuoiThuong(st) + "\nChuoi HT: " + ChuoiHT(st) 
					+ "\nChuoi co " + DemTu(st) + " tu\nChuoi co " + DemNguyenAm(st) + " nguyen am\n").getBytes();
				} else {
					sendData = "Client sent a empty string!".getBytes();
				}
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
				serverSocket.send(sendPacket);
			}
		} catch (Exception ex) {
			
		}
	}
	
	public String ChuoiHoa(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiThuong(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiHT(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			} else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public int DemTu(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public int DemNguyenAm(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i' || s.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}
	
}

public class Bai1_UDP_S {
	public static void main(String[] args) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9999);
		System.out.println("Khởi chạy server thành công!");
		while (true) {
			new Bai1_UDP_ThreadSocket(serverSocket).start();
		}
	}
}
