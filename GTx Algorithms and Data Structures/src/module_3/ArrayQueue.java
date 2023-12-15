package module_3;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {
	public static final int INITIAL_CAPACITY = 5;
	
	private T[] backingArray;
	private int front; // front index
	private int size;
	
	// default constructor.
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		backingArray = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	// adds the data to the back of the queue.
	@SuppressWarnings("unchecked")
	public void enqueue(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null.");
		}
		// new queue is instantiated 
		if(size == 0) {
			// front = 0;
			backingArray[front] = data;
			size++;
		} else if(size == backingArray.length) {
			// create a new array double the size of the original.
			T[] newArray = (T[]) new Object[backingArray.length * 2];
			// copy the elements but realign front to 0.
			for(int i = 0; i < backingArray.length; i++) {
				newArray[i] = backingArray[(front + i) % backingArray.length];
			}
			backingArray = newArray;
			front = 0;
			backingArray[size] = data;
			size++;
		} else {
			backingArray[(front + size) % backingArray.length] = data;
			size++;
		}
	}
	
	// removes and returns the data from the front of the queue.
	public T dequeue() {
		if(size == 0) {
			throw new NoSuchElementException("Queue is empty.");
		}
		T removed = backingArray[front];
		backingArray[front] = null;
		if(front == backingArray.length - 1) {
			front = 0;
		} else {
			front++;
		}
		size--;
		return removed;
	}
	
	// returns the backing array of the queue.
	public T[] getBackingArray() {
		return backingArray;
	}
	
	// returns the size of the queue.
	public int size() {
		return size;
	}
	
	// print out backing array.
	public void printArrayQueue() {
		for (int i = 0; i < backingArray.length; i++) {
			System.out.print(backingArray[i] + " ");
		}
	}
	
	// get the front index.
	public int getFront() {
		return front;
	}
	
	// copies the elements from original array to a new array double the size.
	public Object[] resize() {
		// create a new array double the size of the original.
		Object[] newArray = new Object[backingArray.length * 2];
		// copy the elements of the original to the new array.
		for(int i = 0; i < backingArray.length; i++) {
			newArray[i] = backingArray[i];
		}
		return newArray;
	}

}
