package module_3;

public class ArrayQueue<T> {
	public static final int INITIAL_CAPACITY = 9;
	
	private T[] backingArray;
	private int front;
	private int size;
	
	// default constructor.
	public ArrayQueue() {
		backingArray = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	// adds the data to the back of the queue.
	public void enqueue(T data) {
		// TODO
		size++;
	}
	
	// removes and returns the data from the front of the queue.
	public T dequeue() {
		//TODO
		size--;
		return null;
	}
	
	// returns the backing array of the queue.
	public T[] getBackingArray() {
		return backingArray;
	}
	
	// returns the size of the queue.
	public int size() {
		return size;
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
