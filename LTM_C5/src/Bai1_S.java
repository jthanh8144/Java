import java.io.DataOutputStream;
import java.net.*;
import java.util.Date;

public class Bai1_S {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7788);
		System.out.println("Server is started");
		while (true) {
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String time = new Date().toString();
			dos.writeUTF("Server tra lai ngay gio: " + time);
			socket.close();
		}
	}
}
