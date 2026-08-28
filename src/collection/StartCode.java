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
		System.out.println(names.size());

		ArrayList als = new ArrayList();
		als.add(1234);
		als.add("Sabya");
		System.out.println(als);
		System.out.println(als.contains("Sabyasachi"));
		
		LinkedList lst = new LinkedList();
		lst.add("E-City");
		lst.add(1011);
		lst.addAll(Arrays.asList("Dhl","Hyd"));
		lst.remove("Dhl");
		System.out.println(lst);
		System.out.println(lst.isEmpty());
		
	} 
} 
