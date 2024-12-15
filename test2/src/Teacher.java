
public class Teacher extends Person {
	private String className;
	private int salary;
	private int timeTeaching;
	
	public Teacher(String name, boolean gender, String birthday, String address, String className, int salary, int timeTeaching) {
		super(name, gender, birthday, address);
		this.className = className;
		this.salary = salary;
		this.timeTeaching = timeTeaching;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTimeTeaching() {
		return timeTeaching;
	}

	public void setTimeTeaching(int timeTeaching) {
		this.timeTeaching = timeTeaching;
	}
	
}
