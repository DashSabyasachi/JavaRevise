package oops;

public class Demo {
	public static void main(String[] args) {
		
		Student st1;
		st1 = new Student();
		st1 = new Student(10);
		st1 = new Student(21,"Sabya","BLS");
		
//		st1.studentName = "Sabyasachi";
//		st1.studentId = 31;
//		st1.studentCity = "Bangalore";
		
		st1.showDetails();
		st1.study();
		st1.showFullDetails();
		st1.study(5.2f);
		
		Dog d1 = new Dog();
		d1.eating();
		System.out.println(d1.color); 
	}
}
