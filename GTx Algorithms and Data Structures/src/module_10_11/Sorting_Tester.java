package module_10_11;

public class Sorting_Tester {

	public static void main(String[] args) {
		Integer[] test = new Integer[] {1000, 2014, 231, 53, 10, -92, -9403, 634, -207};
		
		Sorting.quickSort(test);
		print(test);
		
		
	}
	
	public static void print(Integer[] test) {
		for(Integer elem : test) {
			System.out.print(elem + " ");
		}
	}

}
