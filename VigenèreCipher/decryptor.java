import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;
	
	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {

		this.map = _map;
		this.key = _key;
		this.cipher_text = text;
	}

	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}
	
	private void generate_keystream() {

		int TextLength = cipher_text.length();
		int KeyLength = key.length();

		// Compare length of Cipher Text & Key
		if( TextLength < KeyLength){

			//System.out.println("text is shorter");
			// Keystream is the first length of text letters of the key.
			keystream = key.substring(0, TextLength);
		}
		else if(TextLength > KeyLength){
			
			//System.out.println("text is longer");

			String extendedKey = "";
			extendedKey = key;
			
			int count = TextLength - KeyLength -1;
			int indexToCopy = 0;

			// Repeatedly add the key to the end of itself to generate.
			while(count != -1 ){

				if(indexToCopy == KeyLength)
					indexToCopy = 0;

				extendedKey += key.charAt(indexToCopy);

				indexToCopy++;
				count--;
			}
			// Assign generated String to keystream.
			keystream = extendedKey;
            
		}
		else if(TextLength == KeyLength){

			//System.out.println("text and key is equal");
			// Keystream is the same as key.
			keystream = key;
		}
		else{
			// Unknown Case
			System.out.println("Unknown Error");
			return;
		}
	}
	
	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		//System.out.println(cipher_text);
		//System.out.println(keystream);
		
		// Loop through each character in the cipher_text string.
		for(int i = 0; i < cipher_text.length(); i++){

		    // Retrieve the character from the keystream at the current index.
		    Character keyChar = keystream.charAt(i);
		    
		    // Obtain the map (column) associated with the current keystream character.
		    Map<Character, Character> column = map.get(keyChar);

		    // Ensure the column map exists for the current keystream character.
		    if(column != null){
		        // Create an iterator to traverse through the key set of the column map.
		        Iterator<Character> rowIterator = column.keySet().iterator();
		        
		        // Iterate over each character in the key set of the column map.
		        while(rowIterator.hasNext()){
		            
		            // Retrieve the next character from the column's key set.
		            Character columnChar = rowIterator.next();

		            // Check if the character mapped to the columnChar equals the current character in the cipher text.
		            if(column.get(columnChar).equals(cipher_text.charAt(i))){
		                // If a match is found, append the columnChar to the plain_text.
		                plain_text += columnChar;
		            }
		        }
		    }
		}	
	}

	public String get_keystream() {
		// Get Key stream
		return keystream;
	}
	
	public String get_plain_text() {
		// Return Plain Text
		return plain_text;
	}
}
