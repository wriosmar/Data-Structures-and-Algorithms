package module_7;

import java.util.NoSuchElementException;

public class ExternalChainingHashMap<K, V> {
	
	public static final int INITIAL_CAPACITY = 13;
	public static final double MAX_LOAD_FACTOR = 0.67;
	
	private ExternalChainingMapEntry<K, V>[] table;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ExternalChainingHashMap() {
		table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	private ExternalChainingHashMap(int length) {
		table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[length];
	}
	
	public V put(K key, V value) {
		// check key & value are non null
		if(key == null || value == null) {
			throw new IllegalArgumentException("Key and Value can't be null!");
		}
		// check load factor does not exceed max load factor.
		// if it does, resize (2 * oldLength) + 1.
		if((size + 1) % table.length > MAX_LOAD_FACTOR) {
			resizeBackingTable((2 * table.length) + 1);
		}
		
		int hashcode = key.hashCode() % table.length;
		
		if(table[hashcode] == null) {
			// create new LinkedList (ECME) at the index.
			table[hashcode] = new ExternalChainingMapEntry<K, V>(key, value);
		} else {
			// check for duplicate keys at hash code index.
			ExternalChainingMapEntry<K, V> curr = table[hashcode];
			
			while(curr != null) {
				K currKey = curr.getKey();
				if(currKey.equals(key)) {
					// update key's value and save old value.
					V oldValue = curr.getValue();
					curr.setValue(value);
					return oldValue;
				}
				curr = curr.getNext();
			}
			
			// add new <key, value> pair at head of LinkedList (ECME) at hash code index.
			ExternalChainingMapEntry<K, V> head = new ExternalChainingMapEntry<K, V>(key, value);
			head.setNext(table[hashcode]);
			table[hashcode] = head;
		}
		
		size++;
				
		return null;
	}
	
	public V remove(K key) {
		//TODO
		// check key & value are non null
		if(key == null) {
			throw new IllegalArgumentException("Key can't be null!");
		}
		
		int hashcode = key.hashCode() % table.length;
		boolean found = false;
		
		if(table[hashcode] == null) {
			// key is not in table.
			throw new NoSuchElementException("Key doesn't exist!");
		} else {
			// go through LinkedList (ECME) to find key and remove.
			// Throw exception if not found. 
			ExternalChainingMapEntry<K, V> curr = table[hashcode];
			
			while(curr != null || found != true) {
				K currKey = curr.getKey();
				if(currKey.equals(key)) {
					// remove key & value pair and update LinkedList (ECME)
					V removed = curr.getValue();
					
					return removed;
				}
			}
		}
		
		return null;
	}
	
	private void resizeBackingTable(int length) {
		// create new table
		ExternalChainingHashMap<K, V> newTable = new ExternalChainingHashMap<K, V>(length);
		
		// rehash and add entries to new table.
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null) {
				ExternalChainingMapEntry<K, V> curr = table[i];
				
				while(curr != null) {
					newTable.put(curr.getKey(), curr.getValue());
				}
			}
		}
		
		// update the old table to new table.
		table = newTable.getTable();
	}
	
	public ExternalChainingMapEntry<K, V>[] getTable() {
		return table;
	}
	
	public int size() {
		return size;
	}

}
