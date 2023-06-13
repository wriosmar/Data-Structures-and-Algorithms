package module_2;

public class Node<T> {
	private T data;
	private Node<T> next;
	
	// private Node<T> prev;
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(T data) {
		this(data, null);
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
