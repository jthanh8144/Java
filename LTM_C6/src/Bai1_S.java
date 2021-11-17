import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Bai1_S {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			InetAddress IP = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String request = new String(receivePacket.getData());
			System.out.println(request);
			if (request.trim().equals("getDate")) {
				sendData = new Date().toString().getBytes();
			} else {
				sendData = "Server not know what you want?".getBytes();
			}
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, port);
			serverSocket.send(sendPacket);
		}
	}

}
