import java.io.*;
import java.util.*;

public class TongDaySo {
	public static String NhapDaySo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public static void main(String args[]) {
		String s = "";
		System.out.print("Nhap day so: ");
		try {
			s = NhapDaySo();
		}
		catch (Exception e) {
		}
		StringTokenizer st = new StringTokenizer(s, " ");
		int sum = 0;
		while (st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.print("Tong: " + sum);
	}
}
