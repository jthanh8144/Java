interface B{
	void print();
}
interface C{
	void show();
}
public class interfacee implements B, C {
	public void print() {
		System.out.println("Hello");
	}
	public void show() {
		System.out.println("Welcome");
	}
	public static void main(String args[]) {
		interfacee obj = new interfacee();
		obj.print();
		obj.show();
	}
}
