package module_7;

public class ExternalChainingMapEntry<K, V> {
	private K key;
	private V value;
	private ExternalChainingMapEntry<K, V> next;
	
	public ExternalChainingMapEntry(K key, V value) {
		this(key, value, null);
	}
	
	public ExternalChainingMapEntry(K key, V value, ExternalChainingMapEntry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public ExternalChainingMapEntry<K, V> getNext() {
		return next;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public void setNext(ExternalChainingMapEntry<K, V> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		String key = this.key == null ? "null" : this.key.toString();
		String value = this.value == null ? "null" : this.value.toString();
		
		return String.format("%s, %s", key, value);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if(!(o instanceof ExternalChainingMapEntry)) {
			return false;
		} else {
			ExternalChainingMapEntry<K, V> that = (ExternalChainingMapEntry<K, V>) o;
			return that.getKey().equals(key) && that.getValue().equals(value);
		}
	}

}
