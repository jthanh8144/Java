import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai2 {
	public static int NhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public static String DaoSo(int m) {
		
		String s = Integer.toString(m), temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}
	
	public static void SoDX(int M)
	{
		int t1 = M, t2 = 0;
		while (M != 0)
		{
			t2 = t2*10 + (M % 10);
			M /= 10;
		}
		if (t1 == t2) System.out.println(t1 + " la so doi xung.");
		else System.out.println(t1 + " khong phai la so doi xung.");
	}
	
	public static int fibo(int n)
	{
		int a = 1, b = 1, t = 0, count = 2;
		if (n == 1) return 1;
		while (t < n)
		{
			t = a + b;
			a = b;
			b = t;
			count++;
		}
		if (b == n) return count;
		else return 0;
	}
	public static void KtFibo(int K)
	{
		int index = fibo(K);
		if (index == 0) System.out.println(K + " khong thuoc day fibonanci.");
		else System.out.println(K + " la phan tu thu " + index + " cua day fibonanci.");
	}
	
	public static void main(String args[]) {
		int m = 0;
		try {
			do {
				System.out.print("Nhap m = ");
				m = NhapSo();
			}
			while (m < 0);
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("So da dao nguoc: " + DaoSo(m));
		SoDX(m);
		KtFibo(m);
	}
}
