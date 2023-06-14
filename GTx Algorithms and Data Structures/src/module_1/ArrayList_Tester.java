package module_1;

public class ArrayList_Tester {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		
		numbers.addToBack(2);
		numbers.addToFront(1);
		numbers.addToBack(3);
		numbers.addToFront(0);
		numbers.addToBack(4);
		numbers.addToBack(5);
		
		numbers.print();

	}

}
