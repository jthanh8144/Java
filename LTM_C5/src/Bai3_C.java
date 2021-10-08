import java.io.*;
import java.net.Socket;
import java.util.*;

public class Bai3_C {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String st = kb.nextLine();
		dos.writeUTF(st);
		dos.flush();
		st = din.readUTF();
		System.out.println("\nKet qua: ");
		System.out.println(st);
	}

}
