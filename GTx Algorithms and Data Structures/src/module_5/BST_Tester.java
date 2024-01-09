package module_5;

public class BST_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> test = new BST<Integer>();
		
		test.add(1);
		test.add(2);
		test.add(0);
		
		test.remove(1);
		
		test.printBST(test.getRoot());
	}

}
