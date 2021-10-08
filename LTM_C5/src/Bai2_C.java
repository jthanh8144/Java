import java.io.*;
import java.net.Socket;
import java.util.*;

public class Bai2_C {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner kb = new Scanner(System.in);
		while (true) {
			System.out.println("Client: ");
			String msg = kb.nextLine();
			dos.writeUTF("Client: " + msg);
			dos.flush();
			String st = din.readUTF();
			System.out.println(st);
			kb = kb.reset();
		}
	}
}
