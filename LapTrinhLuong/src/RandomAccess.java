import java.io.*;

public class RandomAccess {
	public static void main(String args[]) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("D:/Java/tam.txt", "rw");
		rf.writeBoolean(true);
		rf.writeInt(35);
		rf.writeChar('D');
		rf.writeDouble(8.9);
		//di chuyen con tro dem byte 2
		rf.seek(1);
		System.out.println(rf.readInt());
		System.out.println(rf.readChar());
		System.out.println(rf.readDouble());
		rf.seek(0);
		System.out.println(rf.readBoolean());
		rf.close();
	}
}
