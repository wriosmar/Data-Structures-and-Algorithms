package module_2;

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
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
	}
	
	public void addToBack(T newData) {
		// check if list is empty.
		if(head == null) {
			head = new Node<T>(newData);
			tail = head;
		} else {
			tail.setNext(new Node<T>(newData));
			tail = tail.getNext();
		}
	}
	
	public T removeFromFront() {
		return null;
	}
	
	public T removeFromBack() {
		return null;
	}	

}
