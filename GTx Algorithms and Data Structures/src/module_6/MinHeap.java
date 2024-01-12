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
		if(size + 1 == backingArray.length) {
			backingArray = resize();
		}
		// add element to end of heap.
		backingArray[size + 1] = data;
		size++;
		// up heap start from recently added element.
		upHeap(backingArray, size);
	}
	
	private void upHeap(T[] backingAarray, int currIndex) {
		// base case end of upHeap.
		if(currIndex != 1) {
			int parentIndex = currIndex / 2;
			// if parent is more than child, swap.
			if(backingArray[currIndex].compareTo(backingArray[parentIndex]) <= -1) {
				T parent = backingArray[parentIndex];
				backingArray[parentIndex] = backingArray[currIndex];
				backingArray[currIndex] = parent;
			}
			// recurse
			upHeap(backingArray, parentIndex);
		}
	}
	
	// returns new heap double the capacity. 
	@SuppressWarnings("unchecked")
	private T[] resize() {
		// create new heap double the capacity.
		T[] newArray = (T[]) new Comparable[backingArray.length * 2];
		// move data from old heap to new heap.
		for(int i = 1; i < backingArray.length; i++) {
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
		downHeap(backingArray, 1);
		
		return min;
	}
	
	private void downHeap(T[] backingArray, int currIndex) {
		int priorityIndex = currIndex;
		int leftIndex = 2 * currIndex;
		int rightIndex = 2 * currIndex + 1;
		// if left child is less than priority element, priority is left child.
		if(leftIndex < size + 1 && backingArray[leftIndex].compareTo(backingArray[priorityIndex]) <= -1) {
			priorityIndex = leftIndex;
		}
		// if right child is less than priority element, priority is right child.
		if(rightIndex < size + 1 && backingArray[rightIndex].compareTo(backingArray[priorityIndex]) <= -1) {
			priorityIndex = rightIndex;
		}
		// if priority isn't equal to current index, that means a swap is needed.
		if(priorityIndex != currIndex) {
			T priority = backingArray[priorityIndex];
			backingArray[priorityIndex] = backingArray[currIndex];
			backingArray[currIndex] = priority;
			// recurse 
			downHeap(backingArray, priorityIndex);
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
