package oops;

public class Demo {
	public static void main(String[] args) {
		
		Student st1;
		st1 = new Student();
		st1.studentName = "Sabyasachi";
		st1.studentId = 31;
		st1.studentCity = "Bangalore";
		
		st1.study();
		st1.showFullDetails();
	}
}
