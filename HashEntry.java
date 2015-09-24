package hashTable;

public class HashEntry {

	private String key;
	private int value;
	
	public HashEntry(String key, int value) {		
		this.key = key;
		this.value = Math.abs(value);
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}
	
	
}
