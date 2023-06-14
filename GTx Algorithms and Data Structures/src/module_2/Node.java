package module_2;

public class Node<T> {
	private T data;
	private Node<T> next;
	
	private Node<T> prev;
	
	public Node(T data, Node<T> next, Node<T> prev) {
		this.data = data;
		this.next = next;
		
		this.prev = prev;
	}
	
	public Node(T data) {
		this(data, null, null);
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public Node<T> getPrev(){
		return prev;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

}
