

public class t {
	
	public static void main(String args[]) {
		String lastID = "SV009";
		String nextID = lastID.substring(0, 2);
        int ID = Integer.parseInt(lastID.substring(2)) + 1;
        if (ID < 10) {
            nextID += "00" + ID;
        } else if (ID < 100) {
            nextID += "0" + ID;
        } else {
            nextID += ID;
        }
        System.out.print(nextID);
	}
}
