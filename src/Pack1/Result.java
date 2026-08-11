package Pack1;

import java.util.Scanner;
public class Result{
	public static void main (String[] args){
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter your mark: ");
	int mark = sc.nextInt();
	if(mark > 90){
		System.out.println("Grade :A");
		}
	else if (mark <= 90 && mark > 80) {
		System.out.println("Grade: B");
		}
	else{
		System.out.println("FAIL");
		}
	}
}

