package module_8;

public class AVL<T extends Comparable<? super T>> {
	
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

}
