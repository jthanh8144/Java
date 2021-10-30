package TCP;

import java.io.*;
import java.net.*;

class Bai1_TCP_ThreadSocket extends Thread {
	Socket socket = null;
	public Bai1_TCP_ThreadSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			while (true) {
				String st = din.readUTF();
				dos.writeUTF("Chuoi hoa: " + ChuoiHoa(st) + "\nChuoi thuong: " + ChuoiThuong(st) + "\nChuoi HT: " + ChuoiHT(st) 
						+ "\nChuoi co " + DemTu(st) + " tu\nChuoi co " + DemNguyenAm(st) + " nguyen am\n\n");
				dos.flush();
			}
		} catch (Exception ex) {
			System.out.println("Error");
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

public class Bai1_TCP_S {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Khởi chạy server thành công!");
		while (true) {
			new Bai1_TCP_ThreadSocket(server.accept()).start();
		}
	}
}
