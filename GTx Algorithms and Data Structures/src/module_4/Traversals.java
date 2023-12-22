package module_4;

import java.util.List;
import java.util.LinkedList;

public class Traversals<T extends Comparable<? super T>> {
	
	public List<T> preorder(TreeNode<T> root) {
		LinkedList<T> traverse = new LinkedList<T>();
		return preHelp(root, traverse);
	}
	
	private List<T> preHelp(TreeNode<T> node, List<T> list) {
		if(node != null) {
			list.add(node.getData());
			preHelp(node.getLeft(), list);
			preHelp(node.getRight(), list);
		}
		return list;
	}
	
	public List<T> inorder(TreeNode<T> root) {
		LinkedList<T> traverse = new LinkedList<T>();
		return inHelp(root, traverse);
	}
	
	private List<T> inHelp(TreeNode<T> node, List<T> list) {
		if(node != null) {
			inHelp(node.getLeft(), list);
			list.add(node.getData());
			inHelp(node.getRight(), list);
		}
		return list;
	}
	
	public List<T> postorder(TreeNode<T> root) {
		LinkedList<T> traverse = new LinkedList<T>();
		return postHelp(root, traverse);
	}
	
	private List<T> postHelp(TreeNode<T> node, List<T> list) {
		if(node != null) {
			postHelp(node.getLeft(), list);
			postHelp(node.getRight(), list);
			list.add(node.getData());
		}
		return list;
	}

}
