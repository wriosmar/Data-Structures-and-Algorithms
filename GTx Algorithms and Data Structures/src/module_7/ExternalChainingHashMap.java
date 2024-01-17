package module_7;

public class ExternalChainingHashMap<K, V> {
	
	public static final int INITIAL_CAPACITY = 13;
	public static final double MAX_LOAD_FACTOR = 0.67;
	
	private ExternalChainingMapEntry<K, V>[] table;
	private int size;
	
	public ExternalChainingHashMap() {
		table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[INITIAL_CAPACITY];
	}
	
	public V put(K key, V value) {
		//TODO
		return null;
	}
	
	public V remove(K key) {
		//TODO
		return null;
	}
	
	private void resizeBackingTable(int length) {
		//TODO
	}
	
	public ExternalChainingMapEntry<K, V>[] getTable() {
		return table;
	}
	
	public int size() {
		return size;
	}

}
