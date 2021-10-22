import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Bai2_C {

	public static void main(String[] args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[10000];
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String st = kb.nextLine();
		sendData = st.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String str = new String(receivePacket.getData());
		System.out.println(str);
		clientSocket.close();
	}

}
