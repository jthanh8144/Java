interface Printer{
	void print();
}
interface Shower extends Printer{
	void show();
}
public class TestInterface1 implements Shower {
	public void print() {
		System.out.print("A");
	}
	public void show() {
		System.out.print("B");
	}
	public static void main(String args[]) {
		TestInterface1 o = new TestInterface1();
		o.print();
		o.show();
	}
}
