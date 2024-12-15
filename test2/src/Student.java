
public class Student extends Person {
	private int studentCode;
	private float point;
	
	public Student(String name, boolean gender, String birthday, String address, int studentCode, float point) {
		super(name, gender, birthday, address);
		this.studentCode = studentCode;
		this.point = point;
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}
	
}
