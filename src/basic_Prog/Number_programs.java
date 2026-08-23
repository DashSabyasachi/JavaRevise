package basic_Prog;

public class Number_programs {
	
	
////Armstrong Number

	
//	public static void main(String[] args) {	

//		int num, temp, total, count;
//		
//		num = 153;
//		temp = num;
//		total = 0;
//		count = 0;
//		
//		while (temp > 0) {
//			count += 1;
//			temp /= 10;
//		}
//			
//		temp = num;
//		
//		while (temp>0) {
//			int rem = temp % 10;
//			total += Math.pow(rem,count);
//			temp /= 10;
//		}
//		
//		if(total == num) {
//			 System.out.println("Number is Armstrong ");
//		} else {
//			System.out.println("Number is not Armstrong ");		
//		}
//}	
		
//		Factorial of a number
		public static void main(String[] args) {
			int num = 4;
			
			if(num < 0) System.out.println("Not possible");
			
			else {
				int fact = 1;
			
			for (int i = 1; i<= num; i++) {
				fact = fact * i;
				}
			System.out.println(fact);
			}

		}
		
		
//		Fibonacci series
//		Reverse a number
//		Palindrome number
//		Sum of digits
//		Count digits
//		Multiplication table
		

}
