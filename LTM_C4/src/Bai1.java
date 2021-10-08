import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai1 {
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
	
	public String ChuoiThuong(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public String ChuoiHT(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				temp += (char)(s.charAt(i) - 32);
			} else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				temp += (char)(s.charAt(i) + 32);
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public int DemTu(String s) {
		s = s.trim().replaceAll("( )+", " ");
		System.out.println(s);
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public void TanSuat(String s) {
		boolean isExist = false;
		String temp = "";
		temp += s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			isExist = false;
			for (int j = 0; j < temp.length(); j++) {
				if (s.charAt(i) == temp.charAt(j)) {
					isExist = true;
					break;
				}
			}
			if (isExist == false) {
				temp += s.charAt(i);
			}
		}
		for (int i = 0; i < temp.length(); i++) {
			int t = 0;
			for (int j = 0; j < s.length(); j++) {
				if (temp.charAt(i) == s.charAt(j)) {
					t++;
				}
			}
			System.out.println("Ki tu \"" + temp.charAt(i) + "\" xuat hien " + t + " lan.");
		}
	}
	
	public static void main(String[] args) {
		Bai1 dt = new Bai1();
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
		System.out.println(dt.ChuoiThuong(s));
		System.out.println(dt.ChuoiHT(s));
		System.out.println("\"" + s + "\" co " + dt.DemTu(s) + " tu.");
		dt.TanSuat(s);
	}
}
