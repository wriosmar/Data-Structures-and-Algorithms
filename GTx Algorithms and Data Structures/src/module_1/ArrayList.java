package module_1;

import java.util.NoSuchElementException;

public class ArrayList {
	private int INITIAL_CAPACITY = 5;
	private Object[] array;
	private int size;
	
	// default constructor.
	public ArrayList() {
		array = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	// constructor with user defined capacity.
	public ArrayList(int capacity) {
		array = new Object[capacity];
		size = 0;
	}
	
	// copies the elements from original array to a new array double the capacity.
	// O(n)
	public Object[] resize() {
		// create an new array double the size of the original
		Object[] newArray = new Object[array.length * 2];
		// copy the elements of the original to the new array.
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	// adds an element to the front of the array and shifts elements to the right.
	// O(n)
	public void addToFront(Object newObject) {
		if(newObject == null) {
			throw new IllegalArgumentException("Data can't be null");
		}
		
		// check to see if resize is necessary.
		if(size == array.length) {
			array = resize();
		}
		// shift elements to the right.
		for(int i = size++; i > 0; i--) {
			array[i] = array[i - 1];
		}
		// add new element to the front.
		array[0] = newObject;
	}
	
	// adds an element to the back of the array.
	// O(1)
	public void addToBack(Object newObject) {
		if(newObject == null) {
			throw new IllegalArgumentException("Data can't be null");
		}
		
		// check to see if resize is necessary.
		if(size == array.length) {
			array = resize();
		}
		// add new element to the back.
		array[size++] = newObject;
	}
	
	// removes the first element in the array and shifts elements to the left.
	// returns the removed element.
	// O(n)
	public Object removeFromFront() {
		if(size == 0) {
			throw new NoSuchElementException("Array is empty");
		}
		
		// get removed Object.
		Object removed = array[0];
		// shift elements to the left.
		for(int i = 0; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		array[size - 1] = null;
		size--;
		return removed;
	}
	
	// removes the last element in the array by setting it to null.
	// returns the removed element.
	// O(1)
	public Object removeFromBack() {
		if(size == 0) {
			throw new NoSuchElementException("Array is empty");
		}
		
		// get removed Object.
		Object removed = array[size - 1];
		// last element is set to null.
		array[size - 1] = null;
		size--;
		return removed;
	}
	
	// returns the size of the array.
	public int size() {
		return size;
	}
	
	// returns the element at a given index.
	public Object get(int index) {
		return array[index];
	}
	
	// prints the array. 
	public void print() {
		for(Object elem : array) {
			if(elem != null) {
				System.out.print(elem + " ");
			}
		}
		System.out.println();
	}

}
