import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Bai2_S {
	public static String ChuoiHoa(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public static String ChuoiThuong(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public static String ChuoiHT(String s) {
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
	
	public static int DemTu(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public static int DemNguyenAm(String s) {
		s = s.trim().replaceAll("( )+", " ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i' || s.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[10000];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			InetAddress IP = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String st = new String(receivePacket.getData());
			System.out.println("Chuoi: " + st);
			if (!st.trim().equals("")) {
				sendData = ("Chuoi hoa: " + ChuoiHoa(st) + "\nChuoi thuong: " + ChuoiThuong(st) + "\nChuoi HT: " + ChuoiHT(st) 
				+ "\nChuoi co " + DemTu(st) + " tu\nChuoi co " + DemNguyenAm(st) + " nguyen am").getBytes();
			} else {
				sendData = "Client sent a empty string!".getBytes();
			}
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
			serverSocket.send(sendPacket);
		}
	}

}
