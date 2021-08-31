
class ThongBao1 extends Thread{
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Hello");
		}
	}
}

class ThongBao2 extends Thread{
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Lo cc");
		}
	}
}

public class Vd1 {
	public static void main(String args[]) {
		ThongBao1 dt1 = new ThongBao1();
		dt1.start();
		ThongBao2 dt2 = new ThongBao2();
		dt2.start();
	}
}
