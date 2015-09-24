package hashTable;

public class HashTable {

	HashEntry[] table;
	int tableSize = 128;
	
	HashTable() {		
		table = new HashEntry[tableSize];
		HashEntry emptyEntry = new HashEntry("", 0);
		for(int i = 0; i < tableSize; i++)
			table[i] = emptyEntry;
	}
	
	public void put(HashEntry entry) {
		
		int hash = toHash(entry.getKey());
		int index = hash % tableSize;
		
		while(table[index].getValue() != 0)
			resizeTable();
		
		if(table[index].getValue() <= 0)
			table[index] = entry;
		
	}
	
	
	public int get(String key) {
		
		int hash = toHash(key);
		int index = hash % tableSize;
			
		return table[index].getValue();
	}
	
	public int toHash(String key) {		
		int hash = 7;
		for (int i = 0; i < key.length(); i++)
			hash = hash*31 + key.charAt(i);
		return hash;
	}
	
	public void resizeTable() {
		
		tableSize = tableSize*2;
		HashEntry[] newTable = new HashEntry[tableSize];
		
		for(int i = 0; i < tableSize; i++) {
			
			if(table[i].getValue() > 0) {
				int hash = toHash(table[i].getKey());
				int index = hash % tableSize;
				
				newTable[index] = table[i];
				
			}
		}
		table = newTable;
	}
}
