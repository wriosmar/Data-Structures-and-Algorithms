package module_6;

import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<? super T>> {
	// initial capacity of MinHeap.
	public static final int INITIAL_CAPACITY = 13;
	
	private T[] backingArray;
	private int size;
	
	// constructs a new MinHeap.
	@SuppressWarnings("unchecked")
	public MinHeap() {
		backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
	}
	
	// adds an item to the heap.
	// doubles the capacity if the heap is full.
	public void add(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null!");
		}
		// double the capacity if heap is full.
		if(size == backingArray.length) {
			backingArray = resize();
		}
		// add element to end of heap.
		backingArray[size + 1] = data;
		size++;
		// up heap start from recently added element.
		int currIndex = size;
		// base case is when root index is reached.
		while(currIndex != 1) {
			int parentIndex = currIndex / 2;
			// swap elements if current element is less than parent.
			if(backingArray[currIndex].compareTo(backingArray[parentIndex]) <= -1) {
				T parent = backingArray[parentIndex];
				backingArray[parentIndex] = backingArray[currIndex];
				backingArray[currIndex] = parent;
			}
			currIndex = parentIndex;
		}
	}
	
	// returns new heap double the capacity. 
	@SuppressWarnings("unchecked")
	private T[] resize() {
		// create new heap double the capacity.
		T[] newArray = (T[]) new Comparable[backingArray.length * 2];
		// move data from old heap to new heap.
		for(int i = 1; i < backingArray.length - 1; i++) {
			newArray[i] = backingArray[i];
		}
		
		return newArray;
	}
	
	//TODO
	// removes and returns the minimum item of the heap.
	public T remove() {
		if(size == 0) {
			throw new NoSuchElementException("Heap is empty!");
		}
		// minimum is the root at index 1.
		T min = backingArray[1];
		// move last element to root and remove last element.
		backingArray[1] = backingArray[size];
		backingArray[size] = null;
		size--;
		
		// down heap start from the root index.
		downHeap(backingArray, size, 1);
		
		return min;
	}
	
	private void downHeap(T[] backingArray, int size, int currIndex) {
		int priorityIndex = currIndex;
		int leftIndex = 2 * currIndex;
		int rightIndex = 2 * currIndex + 1;
		
		if(leftIndex < size + 1 && backingArray[leftIndex].compareTo(backingArray[priorityIndex]) <= -1) {
			priorityIndex = leftIndex;
		}
		
		if(rightIndex < size + 1 && backingArray[rightIndex].compareTo(backingArray[priorityIndex]) <= -1) {
			priorityIndex = rightIndex;
		}
		
		if(priorityIndex != currIndex) {
			T swap = backingArray[currIndex];
			backingArray[currIndex] = backingArray[priorityIndex];
			backingArray[priorityIndex] = swap;
			
			downHeap(backingArray, size, priorityIndex);
		}
		
	}
	
	// returns the backing array of the heap.
	public T[] getBackingArray() {
		return backingArray;
	}
	
	// returns the size of the heap.
	public int size() {
		return size;
	}
	
	public void printHeap() {
		for(int i = 0; i <= backingArray.length - 1; i++) {
			System.out.print(" " + backingArray[i]);
		}
	}

}
