
class Bike{
	void run() {
		System.out.println("running");
	}
}
public class Motor extends Bike {
	void run() {
		System.out.println("running safely");
	}
	public static void main(String args[]) {
		Bike b = new Motor();
		b.run();
	}
}