package module_9;

import java.util.Comparator;

public class Sorting {
	
	// Implement Bubble Sort
	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		int stop_index = arr.length - 1;
		
		while(stop_index != 0) {
			int i = 0;
			int last_swapped = 0;
			
			while(i < stop_index) {
				if(comparator.compare(arr[i], arr[i + 1]) > 1) {
					arr = swap(arr, i, i + 1);
					last_swapped = i;
				}
				i++;
			}
			stop_index = last_swapped;
		}
	}
	
	// Implement Selection Sort
	public static<T> void selectionSort(T[] arr, Comparator<T> comparator) {
		//TODO
	}
	
	// Implement Insertion Sort
	public static<T> void insertionSort(T[] arr, Comparator<T> comparator) {
		//TODO
	}
	
	private static <T> T[] swap(T[] arr, int index_1, int index_2) {
		T hold = arr[index_1];
		
		arr[index_1] = arr[index_2];
		arr[index_2] = hold;
		
		return arr;
	}

}
