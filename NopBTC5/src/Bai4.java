import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai4 {
	public static String NhapChu() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public static char InHoa(char s) {
		if (s >= 97 && s <= 122) {
			return (char)(s - 32);
		}
		return s;
	}
	
	public static String VietHoa(String s) {
		String temp = "";
		temp += InHoa(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == ' ') {
				temp += InHoa(s.charAt(i));
			}
			else temp += s.charAt(i);
		}
		return temp;
	}
	
	public static void CatChu(String s) {
		String[] splits = s.split(" ");
        for (String item : splits)
            System.out.println(item);
	}
	
	public static void InKiTu(String s) {
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
			System.out.print(temp.charAt(i) + " ");
		}
		System.out.println();
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
		String s = "";
		try {
			System.out.print("Nhap S: ");
			s = NhapChu();
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("Viet hoa: " + VietHoa(s));
		CatChu(s);
		InKiTu(s);
		System.out.println("\"" + s + "\" co " + DemTu(s) + " tu");
	}
}
