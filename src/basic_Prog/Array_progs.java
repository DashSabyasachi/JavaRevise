package basic_Prog;

public class Array_progs {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Array_progs p = new Array_progs();
		int[] arr = {12, 45, 2, 89, 34, 67};
//		System.out.println(p.findLargest(arr));
//		System.out.println(p.findSmallest(arr));
//		System.out.println(p.sumOfElements(arr));
//		System.out.println(p.searchElement(arr,45));
	}
	
//	Find largest number in an array
	int findLargest(int[] arr) {
		int largest = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}

		return largest;
	}
	
//Find smallest element
	int findSmallest(int[]arr){
		int smallest = arr[0];
		
		for (int i = 1; i<arr.length; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		return smallest;
	}
	
//	Sum of array elements
		int sumOfElements(int[] arr) {
		    int sum = 0;
		    for (int num : arr) {
		        sum += num;
		    }
		    return sum;
		}
		
//	Search for an element
		int searchElement(int[] arr, int target) {
		    for (int i = 0; i < arr.length; i++) {
		        if (arr[i] == target) {
		            return i;
		        }
		    }
		    return -1;
		}
	
}