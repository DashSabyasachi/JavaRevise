package basic_Prog;

public class Number_programs {
	
	
//Armstrong Number
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
//		public static void main(String[] args) {
//			int num = 4;
//			
//			if(num < 0) System.out.println("Not possible");
//			
//			else {
//				int fact = 1;
//			
//			for (int i = 1; i<= num; i++) {
//				fact = fact * i;
//				}
//			System.out.println(fact);
//			}
//
//		}
		
		
//		Fibonacci series
//		public static void main(String[] args) {
//			int a = 0, b = 1;
//			for(int i = 1;i <=10; i ++) {
//				System.out.println(a);
//				int c = a+b;
//				a = b;
//				b = c;		
//			}
//			
//		}	
	
	
//		Reverse a number
//		public static void main(String[] args) {
//			int num = 7548;
//			int rev = 0;
//			while (num > 0) {
//				int rem =  num%10;
//				rev = rev*10 + rem;
//				num = num / 10;
//			}
//			System.out.println(rev);
//		}
		
		
//		Palindrome number
//		public static void main(String[] args) {
//			int num = 12321;
//			int temp = num;
//			int rev = 0;
//			while (num > 0) {
//				int rem = num % 10;
//				rev = rev*10 + rem;
//				num = num /10;
//			}
//			if(temp == rev) System.out.println(rev + " is a palindrome number");
//			else  System.out.println(rev + " is not a palindrome number");
//		}
		
//		Sum of digits in a number
		public static void main(String[] args) {
			int num  =  12345;
			int rem = 0;
			int sum = 0;
			while(num > 0) {
				rem = num % 10;
				sum = sum + rem;
				num = num /10;
			}
			System.out.println(sum);
		}
//		Count digits
//		Multiplication table
		

}
