package module_2;

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	// constructor; sets head and tail to null. 
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
	// adds a new Node to the front of the list. 
	public void addToFront(T newData) {
		// check if list is empty.
		if(head == null) {
			head = new Node<T>(newData);
			tail = head;
		} else {
			Node<T> newNode = new Node<T>(newData);
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	
	// adds a new Node to the back of the list. 
	public void addToBack(T newData) {
		// check if list is empty.
		if(head == null) {
			head = new Node<T>(newData);
			tail = head;
		} else {
			tail.setNext(new Node<T>(newData));
			tail = tail.getNext();
		}
		size++;
	}
	
	// removes a Node from the front of the list.
	public T removeFromFront() {
		Node<T> removedNode = head;
		if(head == tail) {
			head = null;
			tail = null;
		} else {			
			head = head.getNext();			
		}
		size--;
		return removedNode.getData();		
	}
	
	// removes a Node from the back of the list.
	public T removeFromBack() {
		Node<T> removedNode = tail;
		if(head == tail) {
			head = null;
			tail = null;
		} else {
			Node<T> current = head;
			while(current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return removedNode.getData();
	}
	
	// returns the head of the list as String. 
	public String getHead() {
		if(head == null) {
			return "";
		}
		return head.getData().toString();
	}
	
	// returns the tail of the list as String. 
	public String getTail() {
		if(tail == null) {
			return "";
		}
		return tail.getData().toString();
	}
	
	// prints the list out to console. 
	public void print() {
		String print = "";
		Node<T> current = head;
		while(current != null) {
			print += current.getData() + " ";
			current = current.getNext();
		}
		System.out.print(print);
	}

}
