import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai5 {
	static int n, a[];
	public static int NhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public static void Nhap() {
		try {
			System.out.print("Nhap n = ");
			n = NhapSo();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		a = new int[n];
		for (int i = 0; i < n; i++) {
			try {
				System.out.print("a[" + i + "] = ");
				a[i] = NhapSo();
			}
			catch(Exception e) {
				System.out.println("Error");
			}
		}
	}
	
	public static void Xuat() {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static int TongDuongLe() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if ((a[i] > 0) && (a[i] % 2 == 1)) {
				sum += a[i];
			}
		}
		return sum;
	}
	
	public static void TimK() {
		int k = 0;
		try {
			System.out.print("Nhap k = ");
			k = NhapSo();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == k) {
				System.out.println(k + " nam o vi tri " + i + " trong mang");
				return;
			}
		}
		System.out.println(k + " khong xuat hien trong mang");
	}
	
	public static void SapXep() {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Mang sau sap xep:");
		Xuat();
	}
	
	public static void Chen() {
		int p = 0;
		try {
			System.out.print("Nhap k = ");
			p = NhapSo();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		int temp[] = new int [n];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		n++;
		a = new int[n];
		if (p < temp[0]) {
			a[0] = p;
			for (int i = 1; i < n; i++) {
				a[i] = temp[i-1];
			}
		}
		else if (p > temp[n-2]) {
			a[n-1] = p;
			for (int i = 0; i < n-1; i++) {
				a[i] = temp[i];
			}
		}
		else {
			int index = 0;
			for (int i = 0; i < n-1; i++) {
				if (p > temp[i] && p < temp[i+1]) {
					index = i+1;
				}
			}
			for (int i = 0; i < index; i++) {
				a[i] = temp[i];
			}
			a[index] = p;
			for (int i = index + 1; i < n; i++) {
				a[i] = temp[i-1];
			}
		}
		Xuat();
	}
	
	public static void main(String args[]) {
		Nhap();
		System.out.println("Tong cac so duong le trong a la: " + TongDuongLe());
		TimK();
		SapXep();
		Chen();
	}
}
