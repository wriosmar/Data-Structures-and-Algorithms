package module_4;

public class TreeNode<T extends Comparable<? super T>> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	TreeNode(T data) {
		this.data = data;
	}
	
	T getData() {
		return data;
	}
	
	TreeNode<T> getLeft() {
		return left;
	}
	
	TreeNode<T> getRight() {
		return right;
	}
	
	void setData(T data) {
		this.data = data;
	}
	
	void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	void setRight(TreeNode<T> right) {
		this.right = right;
	}

}
