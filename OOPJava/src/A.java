
public class A implements printable{
	public void print()
	{
		System.out.print("Hello");
	}
	public static void main(String args[]) {
		A obj = new A();
		obj.print();
	}

}