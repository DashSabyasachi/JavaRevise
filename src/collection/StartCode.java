package collection;
import java.util.*;
public class StartCode {
	   
	public static void main(String[] args) {
		System.out.println("Welcome to Java code collections.");
		ArrayList<String> names = new ArrayList<>();
		names.add("Sabyasachi");
		names.add("Ramesh");
		names.add("Sonu");  
		System.out.println(names);
		System.out.println(names.get(0));
		System.out.println(names.get(2));
		
		LinkedList lst = new LinkedList();
		lst.add("E-City");
		lst.add("Blr");
		lst.addAll(Arrays.asList("Dhl","Hyd"));
		System.out.println(lst);
		
	}
} 
