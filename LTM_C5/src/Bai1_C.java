import java.io.*;
import java.net.Socket;

public class Bai1_C {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7788);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.println(time);
		socket.close();
	}
}
