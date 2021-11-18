
public class t {
	public static int CheckFibo(String s) {
		int n = Integer.parseInt(s);
		if (n == 1) return 1;
		int index = 2;
		int f1 = 1, f2 = 1, f = 0;
		do {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
			index++;
		} while (f < n);
		if (n != f) {
			return -1;
		} else {
			return index;
		}
	}
	public static void main(String args[]) {
		System.out.print(CheckFibo("8"));
	}
}
