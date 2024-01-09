package module_5;

public class BST_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> test = new BST<Integer>();
		
		test.add(50);
		test.add(15);
		test.add(75);
		test.add(100);
		test.add(5);
		test.add(25);
		test.add(20);
		
		
		test.remove(15);
		
		test.printBST(test.getRoot());
	}

}
