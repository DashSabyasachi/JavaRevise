package stringg;

import java.util.ArrayList;

public class WrapperCls {
	public static void main(String[] args) {
//		Autoboxing (primitive → wrapper, automatic)
//		int num = 10;
//		Integer obj = num;   // autoboxing happens here — int silently becomes Integer
//
//		// Very common real-world case: adding primitives into a collection
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(5);          // 5 (int) is autoboxed into Integer before being stored
//		list.add(10);
//		System.out.println(list);
//		System.out.println(list.getClass());
		
//		Unboxing (wrapper → primitive, automatic)
		Integer obj = 20;
		int num = obj;        // unboxing happens here — Integer silently becomes int

		// Common real-world case: pulling values out of a collection to use in math
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(10);

		int sum = list.get(0) + list.get(1);  // both values unboxed automatically, then added
		System.out.println(sum);             
	}
}
