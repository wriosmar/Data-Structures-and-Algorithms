package module_10_11;

import java.util.Comparator;

public class Sorting {
	// Generic methods are used for the assignment, the rest are for testing purposes and other assignments.
	
	// Implement Bubble Sort
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
	
	// Implement CocktailShakcerSort
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
	
	public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
		if(arr.length <= 1){
			return;
		}
		
		int length = arr.length;
		int mid_idx = length / 2;
		
		T[] left = copy_range(arr, 0, mid_idx);
		T[] right = copy_range(arr, mid_idx, length);
		
		merge(arr, left, right, comparator);
	}
	
	private static <T> void merge(T[] arr, T[] left, T[] right, Comparator<T> comp) {
		int left_idx = 0;
		int right_idx = 0;
		int original_idx = 0;
		
		while(left_idx < left.length && right_idx < right.length) {
			if(comp.compare(left[left_idx], right[right_idx]) <= 0) {
				arr[original_idx] = left[left_idx];
				left_idx++;
			} else {
				arr[original_idx] = right[right_idx];
				right_idx++;
			}
			original_idx++;
		}
		
		while(left_idx < left.length) {
			arr[original_idx] = left[left_idx];
			left_idx++;
			original_idx++;
		}
		
		while(right_idx < right.length) {
			arr[original_idx] = right[right_idx];
			right_idx++;
			original_idx++;
		}
	}
	
	public void mergeSort_int(Integer[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		int length = arr.length;
		int mid_idx = length / 2;
		
		Integer[] left = copy_range_int(arr, 0, mid_idx);	
		Integer[] right = copy_range_int(arr, mid_idx, length);
		
		mergeSort_int(left);
		mergeSort_int(right);
				
		merge_int(arr, left, right);
	}
	
	private static void merge_int(Integer[] arr, Integer[] left, Integer[] right) {
		int left_idx = 0;
		int right_idx = 0;
		int original_idx = 0;
		
		while(left_idx < left.length && right_idx < right.length) {
			if(left[left_idx] <= right[right_idx]) {
				arr[original_idx] = left[left_idx];
				left_idx++;
			} else {
				arr[original_idx] = right[right_idx];
				right_idx++;
			}
			original_idx++;
		}
		
		while(left_idx < left.length) {
			arr[original_idx] = left[left_idx];
			left_idx++;
			original_idx++;
		}
		
		while(right_idx < right.length) {
			arr[original_idx] = right[right_idx];
			right_idx++;
			original_idx++;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T[] copy_range(T[] arr, int start, int end) {
		T[] copy = (T[]) new Object[end - start];
		
		int copy_curr = 0;
		
		for(int i = start; i < end; i++) {
			copy[copy_curr] = arr[i];
			copy_curr++;
		}
		return copy;
	}
	
	private Integer[] copy_range_int(Integer[] arr, int start, int end) {
		Integer[] copy = new Integer[end - start];
		
		int copy_curr = 0;
		
		for(int i = start; i < end; i++) {
			copy[copy_curr] = arr[i];
			copy_curr++;
		}
		return copy;
	}
	
	// swaps elements in an array. 
	private static <T> T[] swap(T[] arr, int index_1, int index_2) {
		T hold = arr[index_1];
		
		arr[index_1] = arr[index_2];
		arr[index_2] = hold;
		
		return arr;
	}
	
	// prints the array.
	private static <T> void print(T[] arr) {
		for(T elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	// prints statistics about the sorting algorithm through each iteration. 
	private static <T> void stats(T[] arr, int iteration, int compares, int swaps) {
		System.out.print("Iteration " + iteration + ": ");
		print(arr);
		System.out.println(compares + " Comparisons");
		System.out.println(swaps + " Swaps");
	}

}
