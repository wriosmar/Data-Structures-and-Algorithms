package module_8;

public class AVL_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL<Integer> ex = new AVL<Integer>();
		
		ex.add(12);
		ex.add(7);
		ex.add(15);
		ex.add(2);
		ex.add(10);
		ex.add(13);
		ex.add(18);
		ex.add(0);
		ex.add(4);
		ex.add(8);
		ex.add(11);
		ex.add(14);
		ex.add(16);
		ex.add(19);
		ex.add(1);
		ex.add(3);
		ex.add(6);
		ex.add(9);
		ex.add(17);
		ex.add(5);
		
		ex.remove(7);
		
		ex.get(ex.getRoot(), 12);
		//ex.get(ex.getRoot(), 7);
		ex.get(ex.getRoot(), 15);
		ex.get(ex.getRoot(), 2);
		ex.get(ex.getRoot(), 10);
		ex.get(ex.getRoot(), 13);
		ex.get(ex.getRoot(), 18);
		ex.get(ex.getRoot(), 0);
		ex.get(ex.getRoot(), 4);
		ex.get(ex.getRoot(), 8);
		ex.get(ex.getRoot(), 11);
		ex.get(ex.getRoot(), 14);
		ex.get(ex.getRoot(), 16);
		ex.get(ex.getRoot(), 19);
		ex.get(ex.getRoot(), 1);
		ex.get(ex.getRoot(), 3);
		ex.get(ex.getRoot(), 6);
		ex.get(ex.getRoot(), 9);
		ex.get(ex.getRoot(), 17);
		ex.get(ex.getRoot(), 5);
		
	}

}
