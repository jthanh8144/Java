import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai1 {
	public int NhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public void UCLN_BCNN(int a, int b) {
		int t1 = a, t2 = b, UCLN = 0, BCNN = 0;
		while (a != b)
		{
			if (a > b) a -= b;
			else b -= a;
		}
		UCLN = a;
		BCNN = t1 * t2 / UCLN;
		System.out.println("UCLN cua " + t1 + " va " + t2 + " la: " + UCLN);
		System.out.println("BCNN cua " + t1 + " va " + t2 + " la: " + BCNN);
	}
	
	public static void main(String args[]) {
		Bai1 dt = new Bai1();
		int a = 0, b = 0;
		try {
			do {
				System.out.print("Nhap a = ");
				a = dt.NhapSo();
				System.out.print("Nhap b = ");
				b = dt.NhapSo();
			}
			while (a <= 0 && b <= 0);
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		dt.UCLN_BCNN(a, b);
	}
}
