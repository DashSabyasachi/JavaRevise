package oops;

public class Student {
	//data:data members: instance variable
	int studentId;
	String studentName;
	String studentCity;
	
	
//	Uses of this keyword
	public Student(int studentId, String studentName, String studentCity) {

	        this.studentId = studentId;
	        this.studentName = studentName;
	        this.studentCity = studentCity;
	    }

	    public void showDetails() {
	        System.out.println("ID: " + this.studentId);
	        System.out.println("Name: " + this.studentName);
	        System.out.println("City: " + this.studentCity);
	    }
	
	    
	    
	    
	    
	public Student() {
		System.out.println("Costructor creted: non-p");
	}
	public Student(int SrNo) {
		System.out.println("Parameterized Costructor :-p)" );
	}
	
//	public Student(int i, String n, String c) {
//		studentId = i;
//		studentName = n;
//		studentCity = c; 
//	}
	
	//Behaviour : member methods : methods: (functions)
	public void study() {
		System.out.println(studentName + " is studying.");
	}
	
	public void study(float f) {
		System.out.println("method overloadng.");
	}
	
	public void showFullDetails() {
		System.out.println("My name is "+ studentName);
		System.out.println("My id is "+ studentId);
		System.out.println("My city is "+ studentCity);
		}
	
}
