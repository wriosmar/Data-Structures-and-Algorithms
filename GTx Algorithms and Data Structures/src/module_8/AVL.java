package module_8;

public class AVL<T extends Comparable<? super T>> {
	
	public void updateHeightAndBF(AVLNode<T> currentNode) {
		//TODO
		
	}
	
	public AVLNode<T> rotateLeft(AVLNode<T> currentNode){
		//TODO
		return null;
	}
	
	public AVLNode<T> rotateRight(AVLNode<T> currentNode){
		//TODO
		return null;
	}
	
	public AVLNode<T> balance(AVLNode<T> currentNode){
		//TODO check conditions.
		// update height and BF of current node.
		updateHeightAndBF(currentNode);
		
		// condition for a right heavy tree.
		if(currentNode.getBalanceFactor() < -1) {
			// condition for a right-left rotation.
			if(currentNode.getRight().getBalanceFactor() > 1) {
				currentNode.setRight(rotateRight(currentNode.getRight()));
			}
			currentNode = rotateLeft(currentNode);
		} // condition for a left heavy tree.
		else if(currentNode.getBalanceFactor() > 1) {
			// condition for a left-right rotation.
			if(currentNode.getLeft().getBalanceFactor() < -1) {
				currentNode.setLeft(rotateLeft(currentNode.getLeft()));
			}
			currentNode = rotateRight(currentNode);
		}
		
		return currentNode;
	}

}
