package module_5;

import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>> {
	private BSTNode<T> root;
	private int size;
	
	public void add(T data) {
		root = addHelp(root, data);
	}
	
	private BSTNode<T> addHelp(BSTNode<T> curr, T data) {
		// null data is not allowed
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null.");
		}
		// base case
		if(curr == null) {
			size++;
			return new BSTNode<T>(data);
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			// data > current data
			curr.setRight(addHelp(curr.getRight(), data));
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			// data < current data
			curr.setLeft(addHelp(curr.getLeft(), data));
			
		}
		return curr;
	}
	
	public T remove(T data) {
		BSTNode<T> hold = new BSTNode<T>(null);
		root = removeHelp(root, data, hold);
		return hold.getData();
	}
	
	private BSTNode<T> removeHelp(BSTNode<T> curr, T data, BSTNode<T> hold) {
		if(data == null) {
			throw new IllegalArgumentException("Data can't be null.");
		}
		// data not found in BST
		if(curr == null) {
			throw new NoSuchElementException("Queue is empty.");
		}
		else if(data.compareTo(curr.getData()) >= 1) {
			// data > current data
			curr.setRight(removeHelp(curr.getRight(), data, hold));
		}
		else if(data.compareTo(curr.getData()) <= -1) {
			// data < current data
			curr.setLeft(removeHelp(curr.getLeft(), data, hold));
		}
		else {
			// data to be removed found
			hold.setData(curr.getData());
			size--;
			if(curr.getRight() == null && curr.getLeft() == null) {
				return null;
			}
			else if(curr.getRight() != null) {
				return curr.getRight();
			}
			else if(curr.getLeft() != null) {
				curr.getLeft();
			}
			else {
				BSTNode<T> holdSwap = new BSTNode<T>(null);
				curr.setRight(successorMove(curr.getRight(), holdSwap));
				curr.setData(holdSwap.getData());
			}
		}		
		return curr;
	}
	
	private BSTNode<T> successorMove(BSTNode<T> curr, BSTNode<T> holdSwap) {
		if(curr.getLeft() == null) {
			holdSwap.setData(curr.getData());
			return curr.getRight();
		}
		else {
			curr.setLeft(successorMove(curr.getLeft(), holdSwap));
		}
		return curr;
	}
	
	public BSTNode<T> getRoot() {
		return root;
	}
	
	public int size() {
		return size;
	}

}
