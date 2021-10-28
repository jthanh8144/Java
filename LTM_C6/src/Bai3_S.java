import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Bai3_S {
	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
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
			System.out.println(receive);
			System.out.print("Server: ");
			String msg = kb.nextLine();
			sendData = ("Server: " + msg).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
			serverSocket.send(sendPacket);
			kb = kb.reset();
		}
	}
	
}
