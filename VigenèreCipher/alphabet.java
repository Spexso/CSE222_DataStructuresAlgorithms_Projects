import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
	private Set<Character> english_alphabet = new LinkedHashSet<Character>();
	private Map<Character, Map<Character, Character>> map = new HashMap<Character,  Map<Character, Character>>();
	
	public alphabet() {
		// do not edit this method
		fill_english_alphabet();
		fill_map();
	}
	
	private void fill_english_alphabet() {
		// do not edit this method
		for(char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
		    english_alphabet.add(c);
		}
	}
	

	private void fill_map() {
		// You must use the "english_alphabet" variable in this method, to fill the "map" variable.
		// You can define 1 or 2 iterators to iterate through the set items.
		
		// Row Index counter
		int rowIndex = 0;	

		// Iterator for rows of Vigenere table	
		Iterator<Character> rowIterator = english_alphabet.iterator();

		// Loop for rows
		while(rowIterator.hasNext()){

			char rowChar = rowIterator.next();
			// Create new map for row's map
			Map<Character, Character> rowMap = new HashMap<>();

			// Column Index to calculate shifting operation
			int columnIndex = 0;
			// Iterator for columns of Vigenere table
			Iterator<Character> columnIterator = english_alphabet.iterator();

			// Loop for columns
			while(columnIterator.hasNext()){

				char columnChar = columnIterator.next();

				// Calculate shifting character by getting mod of row and column numbers sum 
				char shiftedChar = (char) ('A' + (rowIndex + columnIndex) % 26);

				// Put the char to row map
				rowMap.put(columnChar, shiftedChar);
				columnIndex++;
			}

			// Put the row map to map as second entry
			map.put(rowChar, rowMap);
			rowIndex++;
		}
	}

	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for(Character k: map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");
		
	}

	public Map get_map() {
		
		return map;
	}
}