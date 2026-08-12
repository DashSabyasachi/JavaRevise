package Pack1;
public class Result{
	public static void main (String[] args){
		
	int mark = 189;
	
	if(mark > 90 && mark <=100){
		System.out.println("Grade :A");
		}
	else if (mark <= 90 && mark > 80) {
		System.out.println("Grade: B");
		}
	else if (mark >100) {
		System.out.println("Invalid mark " );
		}
	else{
		System.out.println("FAIL");
		}
	}
}



