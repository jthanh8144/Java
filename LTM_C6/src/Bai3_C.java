import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Bai3_C {
	// loi gui ki tu ngan hon se k ghi de dc ki hieu cu
	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		while (true) {
			System.out.print("Client: ");
			String msg = kb.nextLine();
			sendData = ("Client: " + msg).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String str = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			System.out.println(str);
			kb = kb.reset();
		}
	}

}
