package basic_Prog;

public class Pattern_programs {
	public static void main(String[] args) {
		int n = 5;
		
		// 1. Square
		//  * * * * *
		//  * * * * *
		//  * * * * *
		//  * * * * *
		//  * * * * *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("_____________________________");
        
        // 2. Right Triangle
    	//  *
    	//  * *
    	//  * * *
    	//  * * * *
        //  * * * * *
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("_____________________________");
        
        // 3. Inverted Right Triangle
		//  * * * * * 
		//  * * * * 
		//  * * * 
		//  * * 
		//  *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
	}
}