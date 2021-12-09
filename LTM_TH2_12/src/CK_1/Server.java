package CK_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadSocket extends Thread {
	Socket socket = null;
	public ThreadSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			while (true) {
				String st = din.readUTF();
				dos.writeUTF(check(st));
				dos.flush();
			}
		} catch (Exception ex) {
			System.out.println("Ngắt kết nối");
		}
	}
	
	public static String convertBinary(int num){
		String result = "";
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            result += binary[i];
        }
        while (result.length() < 8) {
        	result = "0" + result;
        }
        return result;
    }
	
	public static String check(String st) {
		int n = Integer.parseInt(st);
		String s = convertBinary(n);
		String t = "";
		for (int i = s.length() - 1; i >= 0 ; i--) {
			t += s.charAt(i);
		}
		if (s.equals(t) == true) {
			return "Biểu diễn nhị phân của số đối xứng";
		}
		return "Biểu diễn nhị phân của số không đối xứng";
	}
}

public class Server {
	
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Server is started");
		while (true) {
			new ThreadSocket(server.accept()).start();
		}
	}
}
