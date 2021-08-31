import java.util.Scanner;

public class Bt1 {
	public static int bai1(int a, int b, int c)
	{
		if (a > b) {
			if (a > c) return a;
			return c;
		}
		if (b > c) return b;
		return c;
	}
	public static float bai2(float a, float b)
	{
		if (a == 0) 
		{
			System.out.println("a phai khac 0");
			return -99;
		}
		else return -b/a;
	}
	public static void bai3(float a, float b, float c)
	{
		if (a == 0) 
		{
			System.out.print("Pt la pt bac 1 co nghiem la: ");
			System.out.println(-c/b);
		}
		else
		{
			float delta = 0;
			delta = b*b - 4*a*c;
			if (delta < 0) System.out.println("Pt vo nghiem");
			if (delta == 0) 
			{
				System.out.print("Pt co nghiem kep x = ");
				System.out.println(-b/(2*a));
			}
			else
			{
				System.out.println("Pt co 2 nghiem phan biet");
				System.out.print("x1 = ");
				System.out.println((-b + Math.sqrt(delta)) / (2*a));
				System.out.print("x2 = ");
				System.out.println((-b - Math.sqrt(delta)) / (2*a));
			}
		}
	}
	public static void bai4(float a, float b, float c, float d, float e, float f) 
	{
		float x = 0, y = 0;
		if (a != 0) 
		{
			y = (f - c*d/a) / (e - b*d/a);
			x = (c - b*y)/a;
			
		}
		else
		{
			y = c/b;
			x = (f - e*y)/d;
		}
		System.out.print("x = ");
		System.out.println(x);
		System.out.print("y = ");
		System.out.println(y);
	}
	public static int bai5(int a, int b, int c)
	{
		if (a > b) {
			if (b > c) return b;
			else 
			{
				if (a > c) return c;
				else return a;
			}
		}
		else
		{
			if (a > c) return a;
			else 
			{
				if (b > c) return c;
				else return b;
			}
		}
	}
	public static int bai6(int a, int b) 
	{
		if (b-a < 18) return (b-a)*45000;
		else return (b-a)*60000;
	}
	public static void bai7()
	{
		int month, year;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap thang: ");
		month = sc.nextInt();
		System.out.print("Nhap nam: ");
		year = sc.nextInt();
		if (year < 0)
		{
			System.out.println("Nam > 0");
			return;
		}	
		if (month < 0 || month > 12)
		{
			System.out.println("1 <= thang <= 12");
			return;
		}
		if (month == 2) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) 
				System.out.println("Thang 2 cua nam " + year + " co 29 ngay.");
			else System.out.println("Thang 2 cua nam " + year + " co 28 ngay.");
		}
		else 
		{
			if (month == 4 || month == 6 || month == 9 || month == 11)
				System.out.println("Thang " + month + "cua nam " + year + " co 30 ngay.");
			else System.out.println("Thang " + month + "cua nam " + year + " co 31 ngay.");
		}
	}
	public static float bai8(int n) 
	{
		float t = 0;
		for (int i = 1; i <= n; i++) t += 1/(float) i;
		return t;
	}
	public static int GiaiThua(int n)
	{
		int t = 1;
		if (n <= 0) 
		{
			System.out.println("n > 0");
			return -1;
		}
		for (int i = 1; i <= n; i++) t *= i;
		return t;
	}
	public static float bai9(int n)
	{
		float S = 15;
		if (n < 0) 
		{
			System.out.println("n >= 0");
			return 99;
		}
		if (n == 0) return S;
		for (int i = 1; i <= n; i++) S += Math.pow(-1, i) * (1 / (float) Bt1.GiaiThua(i));
		return S;
	}
	public static float bai10(int n)
	{
		float S = 0;
		if (n < 0) 
		{
			System.out.println("n >= 0");
			return 99;
		}
		for (int i = 1; i <= n; i++) S += 1/ (float)Bt1.GiaiThua(2*i - 1);
		return S;
	}
	public static int bai11(int n) 
	{
		int t = 1;
		if (n % 2 == 0)
			for (int i = 2; i <= n; i += 2) t *= i;
		else for (int i = 1; i <= n; i += 2) t *= i;
		return t;
	}
	public static void bai12(int m)
	{
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
	public static void bai13(int a, int b)
	{
		int t1 = a, t2 = b, UCLN = 0, BCNN = 0;
		while (a != b)
		{
			if (a > b) a -= b;
			else b -= a;
		}
		UCLN = a;
		BCNN = t1 * t2 / UCLN;
		System.out.println("UCLN cua " + a + " va " + b + " la: " + UCLN);
		System.out.println("BCNN cua " + a + " va " + b + " la: " + BCNN);
	}
	public static void bai14()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap m = ");
		int m = sc.nextInt();
		if (m < 2) 
		{
			System.out.println(m + " khong phai la so nguyen to.");
			return;
		}
		for (int i = 2; i <= Math.sqrt(m); i++)
			if (m % i == 0)
			{
				System.out.println(m + " khong phai la so nguyen to.");
				return;
			}
		System.out.println(m + " la so nguyen to.");
	}
	public static void bai15(int P)
	{
		int t = (int)Math.sqrt(P);
		if (t*t == P) System.out.println(P + " la so chinh phuong.");
		else System.out.println(P + " khong phai la so chinh phuong.");
	}
	public static void bai16(int M)
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
	public static boolean snt(int a)
	{
		if (a < 2) return false;
		for (int i = 2; i <= Math.sqrt(a); i++)
			if (a % i == 0) return false;
		return true;
	}
	public static void bai17(int n)
	{
		for (int i = 1; i <= n; i++)
			if (Bt1.snt(i)) System.out.print(i + " ");
	}
	public static boolean shh(int a)
	{
		int t = 0;
		for (int i = 1; i <= a/2; i++)
			if (a % i == 0) t += i;
		if (t == a) return true;
		else return false;
	}
	public static void bai18() 
	{
		for (int i = 1; i <= 1000; i++)
			if (Bt1.shh(i)) System.out.print(i + " ");
	}
	public static void bai19(int n)
	{
		long a = 1, b = 1, t = 0, count = 2;
		System.out.print(a + " " + b + " ");
		while (count < n)
		{
			t = a + b;
			System.out.print(t + " ");
			a = b;
			b = t;
			count++;
		}
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
	public static void bai20(int K)
	{
		if (Bt1.fibo(K) == 0) System.out.println(K + " khong thuoc day fibonanci.");
		else System.out.println(K + " la phan tu thu " + Bt1.fibo(K) + " cua day fibonanci.");
	}
	public static void main(String args[])
	{
		//System.out.println(bai1(1,2,3));
		//System.out.println(bai2(2, 4));
		//bai3(2, -3, 1);
		//bai4(1,1,3,1,-1,1);
		//System.out.println(bai5(1,4,3));
		//System.out.println(bai6(1,3));
		//bai7();
		//System.out.println(bai8(3));
		//System.out.println(bai9(3));
		//System.out.println(bai10(3));
		//bai11(3);
		//bai12(1234);
		//bai13(2, 10);
		//bai14();
		//bai15(15);
		//bai16(162);
		//bai17(9);
		//bai18();
		//bai19(50);
		bai20(3);
	}
}