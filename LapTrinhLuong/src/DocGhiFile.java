import java.io.*;

public class DocGhiFile {
	public static void main(String args[]) throws IOException {
		//Ghi flie
		DataOutputStream out = new DataOutputStream(new FileOutputStream("D:/Java/data.txt"));
		out.writeInt(777);
		out.writeLong(12345677);
		out.writeDouble(123.456);
		out.writeFloat(123.12312345f);
		out.writeBoolean(true);
		out.writeUTF("Abc def");
		out.close();
		//Doc file
		DataInputStream in = new DataInputStream(new FileInputStream("D:/Java/data.txt"));
		try {
			System.out.println("Gt nguyen: " + in.readInt());
			System.out.println("Gt long: " + in.readLong());
			System.out.println("Gt nguyen: " + in.readInt());
			System.out.println("Gt float: " + in.readFloat());
			System.out.println("Gt bool: " + in.readBoolean());
			System.out.println("Gt xau: " + in.readUTF());
		}
		catch (Exception e) {
			System.out.println("Loi");
		}
		in.close();
	}
}
