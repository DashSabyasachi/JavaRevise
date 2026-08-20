package stringg;

public class Stringg1 {
	
public static void main(String[] args) {
	String name="Sabya";
	System.out.println(System.identityHashCode(name));
	name = name + "sachi";
	System.out.println(name);
	System.out.println(System.identityHashCode(name));
	String names ="sabyasachi";
	
	System.out.println(name.length());
	System.out.println(name.charAt(0));
	System.out.println(name.charAt(9));
	System.out.println(name.substring(0,5));
	System.out.println(name.contains("sac"));
	System.out.println(name.equals(names));
	System.out.println(name.equalsIgnoreCase(names));
	
	
//	split()
	String data = "Java,Python,SQL";

	String[] skills = data.split(",");

	for (String skill : skills) {
	    System.out.println("$> "+ skill);
	}
	
	
//	replace()
	String quote = "I like Java";

	String result = quote.replace("Java", "Python");

	System.out.println(result);
	
//	trim()
	String naam = "  LiPuN  ";

	System.out.println(naam.trim());   
	
	
	
	
	String a = new String("Hello");
	String b = new String("Hello");

	System.out.println(a == b);
	System.out.println(a.equals(b));
}
}
