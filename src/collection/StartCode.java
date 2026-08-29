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
		lst.add(4853);
		lst.add("Yomitra");
		System.out.println(lst);
		lst.add(1,"Loam");
		System.out.println(lst);
		lst.set(1, "Bhiya");
		System.out.println(lst);
//		lst.clear();
		System.out.println(lst);

		
		Vector<String> vector = new Vector<>();
		vector.addAll(lst);
		System.out.println("VECTOR "+vector);
		
		
		System.out.println("__________________________");

		HashSet<Double> nms=new HashSet<>();
		nms.add(14.14);
		nms.add(34.12354);
		nms.add(2342.235);
		nms.add(99.3);
		nms.add(99.3);
		nms.add(5.3);
		System.out.println(nms);

		TreeSet<Double> tset = new TreeSet<>();
		tset.addAll(nms);
		System.out.println(tset);
	} 
} 
