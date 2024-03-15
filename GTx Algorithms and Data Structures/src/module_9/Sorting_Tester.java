package module_9;

public class Sorting_Tester {

	public static void main(String[] args) {
		Integer[] test = new Integer[] {1, 0};
		Sorting sort = new Sorting();
		
		sort.insertionSort_int(test);
		print(test);
		
		
	}
	
	public static <T> void print(T[] arr) {
		for(T elem : arr) {
			System.out.print(elem + " ");
		}
	}

}
