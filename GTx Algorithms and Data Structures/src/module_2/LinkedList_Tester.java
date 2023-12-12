package module_2;

public class LinkedList_Tester {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> numbersSSL = new SinglyLinkedList<>();
		
		numbersSSL.addToFront(2);
		numbersSSL.addToBack(3);
		numbersSSL.addToFront(1);
		
		//numbersSSL.removeFromBack();
		//numbersSSL.removeFromBack();
		//numbersSSL.removeFromBack();
		
		numbersSSL.print(); System.out.println();
		
		System.out.print("Head: " + numbersSSL.getHead());
		System.out.println();
		System.out.print("Tail: " + numbersSSL.getTail());
	}

}
