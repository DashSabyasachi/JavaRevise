package exceptions;

public class Main {
	public static void main(String[] args) {

		// ===================================================
		// 1. WHAT IS AN EXCEPTION
		// An unwanted event that disturbs normal program flow.
		// Example: dividing by zero, accessing invalid array index, etc.
		// ===================================================

		// ===================================================
		// 2 & 3. EXCEPTION HANDLING + DEFAULT HANDLER
		// If we DON'T handle it, JVM's default handler prints
		// stack trace and terminates the program abruptly.
		// Uncomment below to see default handler in action:
		//
		// int x = 10 / 0;   // program crashes here, rest of code won't run
		// ===================================================


		// ===================================================
		// 5. TRY-CATCH -> proper exception handling
		// ===================================================
		System.out.println("---- try-catch example ----");
		try {
			int a = 10;
			int b = 0;
			int result = a / b;   // risky code -> throws ArithmeticException
			System.out.println(result); // this line will NOT execute
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero!");
		}
		System.out.println("Program continues after try-catch...\n");


		// ===================================================
		// 4. TYPES OF EXCEPTIONS - UNCHECKED examples
		// ===================================================
		System.out.println("---- Unchecked Exceptions ----");

		// ArithmeticException
		try {
			int r = 5 / 0;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException occurred: " + e.getMessage());
		}

		// NullPointerException
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException occurred: " + e.getMessage());
		}

		// ArrayIndexOutOfBoundsException
		try {
			int[] arr = {1, 2, 3};
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
		}

		// NumberFormatException
		try {
			int num = Integer.parseInt("abc");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException occurred: " + e.getMessage());
		}

		// ClassCastException
		try {
			Object obj = "Hello";
			Integer num = (Integer) obj;
		} catch (ClassCastException e) {
			System.out.println("ClassCastException occurred: " + e.getMessage());
		}

		System.out.println();


		// ===================================================
		// 4. TYPES OF EXCEPTIONS - CHECKED example
		// Checked exceptions MUST be handled (try-catch) or
		// declared using 'throws'. Compiler forces you.
		// ===================================================
		System.out.println("---- Checked Exception ----");
		try {
			readFile(); // this method declares "throws IOException"
		} catch (java.io.IOException e) {
			System.out.println("IOException occurred: " + e.getMessage());
		}
		System.out.println();


		// ===================================================
		// 6. METHODS TO PRINT EXCEPTION INFO
		// ===================================================
		System.out.println("---- Exception printing methods ----");
		try {
			int[] arr = new int[3];
			arr[10] = 50;
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("toString()      : " + e.toString());
			System.out.println("getMessage()    : " + e.getMessage());
			System.out.println("printStackTrace():");
			e.printStackTrace();
		}
		System.out.println();


		// ===================================================
		// 7. FINALLY BLOCK
		// Runs whether exception occurs or not (almost always)
		// ===================================================
		System.out.println("---- finally example ----");
		try {
			int x = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Caught the exception");
		} finally {
			System.out.println("Finally executed (cleanup code goes here)");
		}
		System.out.println();


		// ===================================================
		// 8. THROW KEYWORD
		// Used to manually/explicitly throw an exception
		// ===================================================
		System.out.println("---- throw example ----");
		try {
			validateAge(15); // will throw exception manually
		} catch (RuntimeException e) {
			System.out.println("Caught manually thrown exception: " + e.getMessage());
		}
		System.out.println();


		// ===================================================
		// 9. THROWS KEYWORD
		// Used in method signature to declare possible exceptions
		// (see readFile() method below, and validateAge which uses throw)
		// ===================================================
		System.out.println("---- throws keyword ----");
		System.out.println("See method: static void readFile() throws IOException");
	}


	// -------------------------------------------------------
	// Example method using THROWS (point 9) + CHECKED exception (point 4)
	// -------------------------------------------------------
	static void readFile() throws java.io.IOException {
		// Simulating a risky operation that could throw a checked exception
		throw new java.io.IOException("File not found on disk");
	}


	// -------------------------------------------------------
	// Example method using THROW (point 8)
	// -------------------------------------------------------
	static void validateAge(int age) {
		if (age < 18) {
			throw new RuntimeException("Invalid age: must be 18 or older");
		}
		System.out.println("Age is valid: " + age);
	}
}