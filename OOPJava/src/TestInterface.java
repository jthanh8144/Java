interface B1{
	void print();
}
interface C1{
	void print();
}
public class TestInterface implements B1, C1 {
	public void print() {
		System.out.print("A");
	}
	public static void main(String args[]) {
		TestInterface o = new TestInterface();
		o.print();
	}
}
