package module_6;

public class MinHeap_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap<Integer> test = new MinHeap<Integer>();
		
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(4);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(6);
		test.add(8);
		test.add(9);
		test.add(10);
		//test.add(11);
		//test.add(12);
		//test.add(13);
		
		test.remove();
		//test.add(0);
		
		test.printHeap();

	}

}
