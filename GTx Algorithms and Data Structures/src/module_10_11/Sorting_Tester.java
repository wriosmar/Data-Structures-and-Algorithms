package module_10_11;

public class Sorting_Tester {

	public static void main(String[] args) {
		Integer[] test = new Integer[] {4, 3, 1, 5, 2, 6, 7};
		Sorting sort = new Sorting();
		
		sort.cocktailShakerSort_int(test);
		
		
	}
	
	public static <T> void print(T[] arr) {
		for(T elem : arr) {
			System.out.print(elem + " ");
		}
	}

}
