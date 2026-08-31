package filehandeling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;





public class Main {
	
//	public static void main(String[] args) throws IOException{
//		File file = new File("C:\\Users\\sdash\\JavaProjects\\JavaRevise\\src\\filehandeling\\new.txt");
//		FileWriter writer = new FileWriter(file);
//		
//	    writer.write("Hello Java");
//	    writer.write("\nWelcome to File Handling");
//
//	    writer.close();
//
//	    System.out.println("Data written successfully");
//		}
	


//	public static void main(String[] args) throws IOException {
//
//	    FileReader reader = new FileReader("C:\\Users\\sdash\\JavaProjects\\JavaRevise\\src\\filehandeling\\new.txt");
//
//	    int ch;
//
//	    while ((ch = reader.read()) != -1) {
//	         System.out.print((char) ch);
//	      }
//
//	         reader.close();
//	  }
	
	
	

//	    public static void main(String[] args) throws IOException {
//
//	        BufferedReader reader =
//	            new BufferedReader(new FileReader("C:\\Users\\sdash\\JavaProjects\\JavaRevise\\src\\filehandeling\\new.txt"));
//
//	        String line;
//
//	        while ((line = reader.readLine()) != null) {
//	            System.out.println(line);
//	        }
//
//	        		line = reader.readLine();
//	        String line2 = reader.readLine();
//	        String line3 = reader.readLine();
//	        
//	       System.out.println(line);
//	       System.out.println(line2);
//	       System.out.println(line3);
//
//	       reader.close();
	
	
	
	

	    public static void main(String[] args) throws IOException { 

	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\sdash\\JavaProjects\\JavaRevise\\src\\filehandeling\\new.txt"));

	        writer.write("Java");
	        writer.newLine();
	        writer.write("Spring Boot");
	        writer.newLine();
	        writer.write("React");

	        writer.close();
	    }

	
	
	
	
	
	
	
	
	
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	
	
	
	
	
