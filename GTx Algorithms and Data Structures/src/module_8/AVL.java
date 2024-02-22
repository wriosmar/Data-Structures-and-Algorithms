package module_8;

public class AVL<T extends Comparable<? super T>> {
	
	private AVLNode<T> root;
	private int size;
	
	public void add(T data) {
		root = addHelper(root, data);
	}
	
	private AVLNode<T> addHelper(AVLNode<T> curr, T data){
		// null data is not allowed
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null.");
		}
		// base case
		if(curr == null) {
			size++;
			return new AVLNode<T>(data);
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			// data > current data
			curr.setRight(addHelper(curr.getRight(), data));
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			// data < current data
			curr.setLeft(addHelper(curr.getLeft(), data));
		}
		return curr;
	}
	
	public T remove(T data) {
		AVLNode<T> hold = new AVLNode<T>(null);
		return null;
	}
	
	private AVLNode<T> removeHelper(AVLNode<T> curr, T data, AVLNode<T> hold) {
		return null;
	}
	
	private AVLNode<T> successor(AVLNode<T> curr, AVLNode<T> holdSwap) {
		if(curr.getLeft() == null) {
			holdSwap.setData(curr.getData());
			return curr.getRight();
		} else {
			curr.setLeft(successor(curr.getLeft(), holdSwap));
			return curr;
		}
	}
	
	public void updateHeightAndBF(AVLNode<T> currentNode) {
		int leftChildHeight;
		int rightChildHeight;
		
		if(currentNode.getLeft() == null) {
			leftChildHeight = -1;
		} else {
			leftChildHeight = currentNode.getLeft().getHeight();
		}
		
		if(currentNode.getRight() == null) {
			rightChildHeight = -1;
		} else {
			rightChildHeight = currentNode.getRight().getHeight();
		}
		
		currentNode.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1);
		currentNode.setBalanceFactor(leftChildHeight - rightChildHeight);
	}
	
	public AVLNode<T> rotateLeft(AVLNode<T> currentNode){
		AVLNode<T> rotateNode = currentNode.getRight();
		
		currentNode.setRight(rotateNode.getLeft());
		
		rotateNode.setLeft(currentNode);
		
		updateHeightAndBF(currentNode);
		updateHeightAndBF(rotateNode);
		
		return rotateNode;
	}
	
	public AVLNode<T> rotateRight(AVLNode<T> currentNode){
		AVLNode<T> rotateNode = currentNode.getLeft();
		
		currentNode.setLeft(rotateNode.getRight());
		
		rotateNode.setRight(currentNode);
		
		updateHeightAndBF(currentNode);
		updateHeightAndBF(rotateNode);
		
		return rotateNode;
	}
	
	public AVLNode<T> balance(AVLNode<T> currentNode){
		// update height and BF of current node.
		updateHeightAndBF(currentNode);
		
		// condition for a right heavy tree.
		if(currentNode.getBalanceFactor() < -1) {
			// condition for a right-left rotation.
			if(currentNode.getRight().getBalanceFactor() >= 1) {
				currentNode.setRight(rotateRight(currentNode.getRight()));
			}
			currentNode = rotateLeft(currentNode);
		} // condition for a left heavy tree.
		else if(currentNode.getBalanceFactor() > 1) {
			// condition for a left-right rotation.
			if(currentNode.getLeft().getBalanceFactor() <= -1) {
				currentNode.setLeft(rotateLeft(currentNode.getLeft()));
			}
			currentNode = rotateRight(currentNode);
		}
		
		return currentNode;
	}
	
	public AVLNode<T> getRoot(){
		return root;
	}
	
	public int size() {
		return size;
	}

}
