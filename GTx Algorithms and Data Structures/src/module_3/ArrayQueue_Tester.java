package module_3;

public class ArrayQueue_Tester {

	public static void main(String[] args) {
		ArrayQueue<Integer> numbers = new ArrayQueue<>();
		
		numbers.enqueue(0);
		numbers.enqueue(1);
		// numbers.enqueue(2);
		
		System.out.println("Size: " + numbers.size());
		
		System.out.println("DeQueued: " + numbers.dequeue());
		System.out.println("DeQueued: " + numbers.dequeue());
		// System.out.println("DeQueued: " + numbers.dequeue());
		
		System.out.println("Size: " + numbers.size());
		
		numbers.enqueue(0);
		numbers.enqueue(1);
		numbers.enqueue(2);
		numbers.enqueue(3);
		numbers.enqueue(4);
		
		//numbers.enqueue(5);
		
		System.out.println("Size: " + numbers.size());
		
		System.out.println("DeQueued: " + numbers.dequeue());
		System.out.println("DeQueued: " + numbers.dequeue());
		System.out.println("DeQueued: " + numbers.dequeue());
		
		System.out.println("DeQueued: " + numbers.dequeue());
		System.out.println("DeQueued: " + numbers.dequeue());
		
		// System.out.println("DeQueued: " + numbers.dequeue());
		
		System.out.println("Front: " + numbers.getFront());
		numbers.printArrayQueue();
	}

}
