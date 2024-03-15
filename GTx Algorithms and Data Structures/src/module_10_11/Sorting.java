package module_10_11;

import java.util.Comparator;

public class Sorting {
	// Generic methods are used for the assignment, the rest are for testing purposes and other assignments.
	
	// Implement Bubble Sort
	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		int stop_index = arr.length - 1;
		
		while(stop_index != 0) {
			int i = 0;
			int last_swapped = 0;
			
			while(i < stop_index) {
				if(comparator.compare(arr[i], arr[i + 1]) > 0) {
					arr = swap(arr, i, i + 1);
					last_swapped = i;
				}
				i++;
			}
			stop_index = last_swapped;
		}
	}
	
	// Testing algorithm
	public void bubbleSort_int(Integer[] arr) {
		int iter = 0;
		int compares = 0;
		int swaps = 0;
		
		int stop_index = arr.length - 1;
		
		while(stop_index != 0) {
			iter++;
			
			int i = 0;
			int last_swapped = 0;
			
			while(i < stop_index) {
				compares++;
				if(arr[i].compareTo(arr[i + 1]) > 0) {
					swaps++;
					arr = swap(arr, i, i + 1);
					last_swapped = i;
				}
				i++;
			}
			stop_index = last_swapped;
			
			stats(arr, iter, compares, swaps);
		}
	}
	
	// Implement Selection Sort
	public static<T> void selectionSort(T[] arr, Comparator<T> comparator) {
		for(int n = arr.length - 1; n > 0; n--) {
			int max_index = n;
			
			for(int i = 0; i < n; i++) {
				if(comparator.compare(arr[i], arr[max_index]) > 0) {
					max_index = i;
				}
			}
			arr = swap(arr, n, max_index);
		}
	}
	
	// Testing algorithm
	public void selectionSort_int(Integer[] arr) {
		int iter = 0;
		int compares = 0;
		int swaps = 0;
		
		for(int n = arr.length - 1; n > 0; n--) {
			iter++;
			
			int max_index = n;
			
			for(int i = 0; i < n; i++) {
				compares++;
				if(arr[i].compareTo(arr[max_index]) > 0) {
					max_index = i;
				}
			}
			swaps++;
			arr = swap(arr, n, max_index);
			
			stats(arr, iter, compares, swaps);
		}
	}
	
	// Implement Insertion Sort
	public static<T> void insertionSort(T[] arr, Comparator<T> comparator) {
		for(int n = 0; n < arr.length - 1; n++) {
			int i = n + 1;
			
			while(i != 0 && comparator.compare(arr[i], arr[i - 1]) < 0) {
				arr = swap(arr, i, i - 1);
				i--;
			}
		}
	}
	
	// Testing algorithm
	public void insertionSort_int(Integer[] arr) {
		int iter = 0;
		int compares = 0;
		int swaps = 0;
		
		for(int n = 0; n < arr.length - 1; n++) {
			iter++;
			
			int i = n + 1;
			
			while(i != 0 && arr[i].compareTo(arr[i - 1]) < 0) {
				compares++;
				swaps++;
				
				arr = swap(arr, i, i - 1);
				i--;
			}
			
			stats(arr, iter, compares + 1, swaps);
		}
	}
	
	public void cocktailShakerSort_int(Integer[] arr) {
		int iter = 0;
		int compares = 0;
		int swaps = 0;
		
		int end = arr.length - 1;
		int start = 0;
		
		int last_swapped;
		
		while(arr[start].compareTo(arr[end]) < 0) {
			iter++;
			
			last_swapped = start;
			for(int i = start; i < end; i++) {
				compares++;
				if(arr[i].compareTo(arr[i + 1]) > 0) {
					swaps++;
					swap(arr, i, i + 1);
					last_swapped = i;
				}
			}
			end = last_swapped;
			for(int j = end; j > start; j--) {
				compares++;
				if(arr[j].compareTo(arr[j - 1]) < 0) {
					swaps++;
					swap(arr, j, j - 1);
					last_swapped = j;
				}
			}
			start = last_swapped;
			
			stats(arr, iter, compares, swaps);
		}
	}
	
	private static <T> T[] swap(T[] arr, int index_1, int index_2) {
		T hold = arr[index_1];
		
		arr[index_1] = arr[index_2];
		arr[index_2] = hold;
		
		return arr;
	}
	
	private static <T> void print(T[] arr) {
		for(T elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	private static <T> void stats(T[] arr, int iteration, int compares, int swaps) {
		System.out.print("Iteration " + iteration + ": ");
		print(arr);
		System.out.println(compares + " Comparisons");
		System.out.println(swaps + " Swaps");
	}

}
