import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tongtichcacchuso {
	public int NhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public void TongTich(int m) {
		int S = 0, P = 1;
		while (m / 10 != 0)
		{
			S += m % 10;
			P *= m % 10;
			m /= 10;
		}
		S += m;
		P *= m;
		System.out.println("Tong cac chu so cua " + m + " la: " + S);
		System.out.println("Tich cac chu so cua " + m + " la: " + P);
	}
	
	public static void main(String args[]) {
		Tongtichcacchuso dt = new Tongtichcacchuso();
		int m = 0;
		try {
			do {
				System.out.print("Nhap so nguyen duong: ");
				m = dt.NhapSo();
			}
			while (m <= 0);
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("So da nhap la: " + m);
		dt.TongTich(m);
	}
}
