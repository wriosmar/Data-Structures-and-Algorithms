package module_8;

import java.util.NoSuchElementException;

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
			return balance(new AVLNode<T>(data));
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			// data > current data
			curr.setRight(addHelper(curr.getRight(), data));
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			// data < current data
			curr.setLeft(addHelper(curr.getLeft(), data));
		}
		
		return balance(curr);
	}
	
	public T remove(T data) {
		AVLNode<T> hold = new AVLNode<T>(null);
		root = removeHelper(root, data, hold);
		return hold.getData();
	}
	
	private AVLNode<T> removeHelper(AVLNode<T> curr, T data, AVLNode<T> hold) {
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null.");
		}
		// data not found in AVL
		if(curr == null) {
			throw new NoSuchElementException("Data not found in AVL Tree.");
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			// data > current data
			curr.setRight(removeHelper(curr.getRight(), data, hold));
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			// data < current data
			curr.setLeft(removeHelper(curr.getLeft(), data, hold));
		}
		else {
			// data to be removed found.
			hold.setData(curr.getData());
			size--;
			if(curr.getRight() == null && curr.getLeft() == null) {
				return null;
			}
			else if(curr.getRight() != null && curr.getLeft() == null) {
				return curr.getRight();
			}
			else if(curr.getLeft() != null && curr.getRight() == null) {
				return curr.getLeft();
			}
			else {
				AVLNode<T> swap = new AVLNode<T>(null);
				curr.setRight(successor(curr.getRight(), swap));
				curr.setData(swap.getData());
			}
		}
		return balance(curr);
	}
	
	private AVLNode<T> successor(AVLNode<T> curr, AVLNode<T> swap) {
		if(curr.getLeft() == null) {
			swap.setData(curr.getData());
			return curr.getRight();
		} else {
			curr.setLeft(successor(curr.getLeft(), swap));
			return balance(curr);
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
	
	
	// EXTRA METHODS FOR TESTING
	public void get(AVLNode<T> curr, T data) {
		if(curr == null) {
			System.out.println("NOT FOUND");
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			curr = curr.getRight();
			get(curr, data);
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			curr = curr.getLeft();
			get(curr, data);
		}
		else {
			System.out.println(curr.getData() + " " + curr.getHeight() + " " + curr.getBalanceFactor());
		}
	}

}
