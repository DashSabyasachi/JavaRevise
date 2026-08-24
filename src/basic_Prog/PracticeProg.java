package basic_Prog;

public class PracticeProg {

	public static void main(String[] args) {
		
//		Hello World	
//		System.out.println("Hello World");
		
//		Add two number
//		int a = 45;
//		int b = 25;
//		System.out.println(a+b);
		
//		Subtract two numbers
//		int a = 45;
//		int b = 25;
//		System.out.println(a-b);
		
//		Multiply two numbers
//		int a = 45;
//		int b = 5;
//		System.out.println(a*b);
		
//		Even/odd
//		int a = 40;
//		if (a%2 == 0) {
//			System.out.println(a + " is Even");
//		}else {
//			System.out.println(a + " is Odd");
//		}	
		
//		Positive/negative
//		int a = -40;
//		if (a>0) {
//			System.out.println(a + " is a positive number");
//		}else {
//			System.out.println(a + " is a negative number");
//		}
		
//		Largest of two numbers
//		int a = 100;
//		int b = 40;
//		if (a > b) {
//			System.out.println(a);
//		}else {
//			System.out.println(b);
//		}
		
//		Largest of three numbers
//		int a = 100;
//		int b = 400;
//		int c = 1252; 
//		int largest;
//		
//		if (a >= b && a >= c) {
//			largest = a;
//		}else if (b >= a && b >= c){
//			largest = b;
//		}
//		else {
//			largest = c;
//		}
//		System.out.println("Largest number: " + largest);
		
		PracticeProg p= new PracticeProg();
		System.out.println(p.add(12, 13));	
	}
	
	 int add(int a,int b) {
		int c=a+b;
		return c;
		
	}
	
	
}
