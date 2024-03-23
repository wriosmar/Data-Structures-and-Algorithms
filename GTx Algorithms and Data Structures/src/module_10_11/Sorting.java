package module_10_11;

import java.util.LinkedList;

public class Sorting {
	// Generic methods are used for the assignment, the rest are for testing purposes and other assignments.
	
	// Implement Bubble Sort.
	public void bubbleSort(Integer[] arr) {
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
	
	// Implement Selection Sort.
	public void selectionSort(Integer[] arr) {
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
	
	// Implement Insertion Sort.
	public void insertionSort(Integer[] arr) {
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
	
	// Implement CocktailShakcerSort.
	public void cocktailShakerSort(Integer[] arr) {
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
	
	// Implement LSD Radix Sort.
	@SuppressWarnings("unchecked")
	public static void lsdRadixSort(Integer[] arr) {
		LinkedList<Integer>[] buckets = new LinkedList[19];
		
		for(int n = 0; n < buckets.length; n++) {
			buckets[n] = new LinkedList<>();
		}
		
		int k = getMaxLength(arr);
		int length = arr.length;
		
		int base = 1;
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < length; j++) {
				int bucket = (arr[j] / base % 10 + 9);
				
				buckets[bucket].add(arr[j]);
			}
			
			int index = 0;
			for(LinkedList<Integer> bucket : buckets) {
				while(bucket.isEmpty() != true) {
					arr[index] = bucket.pop();
					index++;
				}
			}
			
			base = base * 10;
		}
	}
	
	// Get the max length of an array of Integers.
	// Helper method for LSD Radix.
	private static int getMaxLength(Integer[] arr) {
		int max_length = 0;
		
		for(int num : arr) {
			int abs_val_length = String.valueOf(Math.abs(num)).length();
			if(abs_val_length > max_length) {
				max_length = abs_val_length;
			}
		}
		
		return max_length;
	}
	
	// Implement Merge Sort.
	public void mergeSort(Integer[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		int length = arr.length;
		int mid_idx = length / 2;
		
		Integer[] left = copy_range_int(arr, 0, mid_idx);	
		Integer[] right = copy_range_int(arr, mid_idx, length);
		
		mergeSort(left);
		mergeSort(right);
				
		merge(arr, left, right);
	}
	
	// Helper method for Merge Sort.
	private static void merge(Integer[] arr, Integer[] left, Integer[] right) {
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
	
	// Splits an array of Integers via the provided start and end indices.
	// Helper method for Merge Sort. 
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
