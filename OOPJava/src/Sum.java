
public class Sum {
	void sum(int a, int b) {
		System.out.println("int arg method invoked");
	}
	void sum(long a, long b) {
		System.out.println("long arg");
	}
	public static void main(String s[])
	{
		Sum o = new Sum();
		o.sum(20, 20);
	}
}
