import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai6 {
	static int m, n, a[][], x[];
	
	public static int NhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public static void Nhap() {
		try {
			System.out.print("Nhap so dong m = ");
			m = NhapSo();
			System.out.print("Nhap so cot n = ");
			n = NhapSo();
			a = new int [m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("a[" + i + "][" + j + "] = ");
					a[i][j] = NhapSo();
				}
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	public static void Xuat() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int TichBoi3() {
		int p = 1;
		for (int i = 0; i < n; i++) {
			if (a[0][i] % 3 == 0) {
				p *= a[0][i];
			}
		}
		return p;
	}
	
	public static void MangMax() {
		x = new int[m];
		for (int i = 0; i < m; i++) {
			int max = a[i][0];
			for (int j = 1; j < n; j++) {
				if (max < a[i][j]) {
					max = a[i][j];
				}
			}
			x[i] = max;
		}
		System.out.print("X: ");
		for (int i = 0; i < m; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}
	
	public static void XoaPt() {
		int t[] = new int[m-1];
		for (int i = 1; i < m; i++) {
			t[i-1] = x[i];
		}
		x = new int[m-1];
		System.out.print("X: ");
		for (int i = 0; i < m-1; i++) {
			x[i] = t[i];
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		Nhap();
		System.out.println("Tich cac so boi 3 tren dong dau tien: " + TichBoi3());
		MangMax();
		XoaPt();
	}
}
