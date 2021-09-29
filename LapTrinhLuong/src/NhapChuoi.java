import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NhapChuoi {
	public String NhapChu() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public String DaoChuoi(String s) {
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiHoa(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public static int DemTu(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public static void main(String args[]) {
		NhapChuoi dt = new NhapChuoi();
		String s = "";
		try {
			System.out.print("Nhap S: ");
			s = dt.NhapChu();
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("Chuoi da nhap: " + s);
		System.out.println(dt.DaoChuoi(s));
		System.out.println(dt.ChuoiHoa(s));
	}
}
