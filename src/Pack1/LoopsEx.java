package Pack1;

public class LoopsEx {
	public static void main(String[] args) {
		//For loop
		for(int i =1;i<=10;i++) 
			if(i%2 == 0) {
				System.out.println(i);
				System.out.println(i+1);
			}
		//While Loop
		int i = 1;
		while( i <= 10) {
			System.out.println(i);
			i++;
			}
		//do while loop
		i = 10;

        do {
            System.out.println(i);
            i++;
        } while (i <= 15);
 		
		// for each
		int[] numbers = {10,20,30,40,50};
		for (int num:numbers) {
			System.out.println(num);
			}
		}	
	}


