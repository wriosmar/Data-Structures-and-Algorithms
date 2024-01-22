package module_7;

public class ChainHashMap_Tester {

	public static void main(String[] args) {
		ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<Integer, Integer>();
		
		test.put(0, 0);
		test.put(1, 1);
		test.put(2, 2);
		test.put(3, 3);
		test.put(4, 4);
		test.put(5, 5);
		test.put(6, 6);
		test.put(7, 7);
		
		System.out.println(test.size());
		System.out.println(test.getTable().length);
		
		test.put(8, 8);
		
		System.out.println();
		
		System.out.println(test.size());
		System.out.println(test.getTable().length);
		
		System.out.println();
		
		System.out.println(test.getTable()[0]);
		System.out.println(test.getTable()[0].getNext());
		
	}

}
