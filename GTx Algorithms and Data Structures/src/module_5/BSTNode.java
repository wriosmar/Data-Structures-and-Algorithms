package module_5;

public class BSTNode<T extends Comparable<? super T>> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	BSTNode(T data) {
		this.data = data;
	}
	
	T getData() {
		return data;
	}
	
	BSTNode<T> getLeft() {
		return left;
	}
	
	BSTNode<T> getRight() {
		return right;
	}
	
	void setData(T data) {
		this.data = data;
	}
	
	void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	void setRight(BSTNode<T> right) {
		this.right = right;
	}

}
