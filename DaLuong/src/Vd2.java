class Chao1 implements Runnable {
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Hello");
		}
	}
}

class Chao2 extends Thread{
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Lo cc");
		}
	}
}

public class Vd2 {
	public static void main(String args[]) {
		Thread dt1 = new Thread(new Chao1());
		dt1.start();
		Thread dt2 = new Thread(new Chao2());
		dt2.start();
	}
}
