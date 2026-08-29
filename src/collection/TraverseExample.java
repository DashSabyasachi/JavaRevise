package collection;
import java.util.*;
public class TraverseExample {
	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Damesh");
		names.add("Sitara");
		names.add("Rohan");
		names.add("Vandna");
		names.add("Vardhin");
		
		
//Traversing using for each loop
		for(String str: names) {
			//	System.out.println(str + "\t" +str.length() + "\t");
			StringBuffer strBfr = new StringBuffer(str);
			System.out.println(str + "\t" +str.length() + "\t" +strBfr.reverse() );
			
		}
		System.out.println("___________________________");
		
		
//Traversing using ITERATOR
		Iterator<String> itr = names.iterator();
		while(itr.hasNext())
		{	
		String next = itr.next();
		System.out.println(next);
		}
		System.out.println("+++++++++++++++++++++++");

//Backward traversal of collection LISTITERATOR
		ListIterator<String> litr = names.listIterator(names. size());
		while(litr.hasPrevious())
		{
		String previous = litr.previous();
		System.out.println(previous);
		}
		
//Enumeration    ?????
		
		
		System.out.println("++++++++FOR EACH METHOD++++++++++");
		
//for each method

		names. forEach(str->{
			System.out.println(str);
		});
		
//Sorting of elements
		System.out.println("Sorting of elements");
		TreeSet<String> set = new TreeSet();
//		System.out.println(set);
		set.addAll(names);
//		System.out.println(set);
		set.forEach(e->{
			System.out.println(e);
		});
	}
}
