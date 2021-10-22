import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Bai1_C {

	public static void main(String[] args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		sendData = "getDate".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String str = new String(receivePacket.getData());
		System.out.println(str);
		clientSocket.close();
	}

}
