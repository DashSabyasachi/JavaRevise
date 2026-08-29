package collection;
import java.util.*;
public class MapExample {
	public static void main(String[] args) {
		HashMap<String,Integer> courses = new HashMap<>();
		
		courses.put("Java",5000);
		courses.put("Python",4500);
		courses.put("Spring",8000);
		courses.put("Android",10000);
		courses.put("MBA",700000);
		
		System.out.println(courses);
		
		courses. forEach((key,value)->{
			System.out.print(key);
			System.out.print("=>");
			System.out.println(value);
			System.out.println();

			});

			//entry set
			//key set
		
		System.out.println(courses.get("Java"));
	}
}
