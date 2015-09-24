package hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		HashTable table = new HashTable();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("This HashTable keeps track of first names and ages over zero");
		while(true) {
		
		String s = br.readLine();
		
		String[] arguments = s.split("\\s+");
		
		if(arguments.length > 3 ) {
			System.out.println("Invalid Input");		
		}
		
		if(arguments.length == 3 && arguments[2].matches("^-?\\d+$")
				&& arguments[0].equals("store")) {
			
				int age = Integer.parseInt(arguments[2]);			
				HashEntry entry = new HashEntry(arguments[1], age);
				table.put(entry);
				System.out.println("Stored " + arguments[1]);
			
		}
		
		if(arguments.length == 2 && arguments[0].equals("get")) {
			
			System.out.println(arguments[1] + " is " + table.get(arguments[1]) + " years old");
		}
		}
	}
	

}
