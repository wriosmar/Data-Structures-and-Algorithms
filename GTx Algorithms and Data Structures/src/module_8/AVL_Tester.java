package module_8;

public class AVL_Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL<Integer> ex = new AVL<Integer>();
		
		ex.add(7);
		
		ex.add(4);
		
		System.out.println(ex.getRoot().getData() + " " + ex.getRoot().getHeight() + " " + ex.getRoot().getBalanceFactor());
		System.out.println(ex.getRoot().getLeft().getData() + " " + ex.getRoot().getLeft().getHeight() + " " + ex.getRoot().getLeft().getBalanceFactor());
	}

}
