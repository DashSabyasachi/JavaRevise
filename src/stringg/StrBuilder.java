package stringg;
//StringBuilder is useful when you need to modify a String many times.
public class StrBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");

		sb.append(" Java");

		System.out.println(sb);
		
		System.out.println(sb.insert(0, "Hi "));
		System.out.println(sb.replace(0, 2, "Hey"));
		sb.delete(0, 4);
		sb.reverse();
		
		
	}
}

