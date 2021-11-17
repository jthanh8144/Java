
public class t {
	public static boolean Check(String s) {
		int n = Integer.parseInt(s);
		int f1 = 1, f2 = 2, f = 0;
		do {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		} while (f < n);
		if (n != f) {
			return false;
		} else {
			return true;
		}
	}
	public static void main(String args[]) {
		System.out.print(Check("5"));
	}
}
