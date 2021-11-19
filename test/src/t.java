
public class t {
	public static String calculate(String st) {
		String[] items = st.split("\\s");
		double A = Double.parseDouble(items[0]);
		double B = Double.parseDouble(items[2]);
		double result = 0;
		switch (items[1]) {
		case "+":
			result = A + B;
			break;
		case "-":
			result = A - B;
			break;
		case "*":
			result = A * B;
			break;
		case "/":
			result = A / B;
			break;
		default:
			return "error";
		}
		return Double.toString(result);
	}
	public static void main(String args[]) {
		System.out.print(calculate("8 + 3"));
	}
}
