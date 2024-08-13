import java.util.Map;

public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";
	
	// Encryptor Constructor 
	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		// Initialize all fields	
		this.map = _map;
		this.key = _key;
		this.plain_text = text;
	}
	
	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}
	
	private void generate_keystream() {

		// Initialize variables for length of plain text and key  
		int TextLength = plain_text.length();
		int KeyLength = key.length();

		// Compare length of Plain Text & Key
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
	
	private void generate_cipher_text() {

		// Loop through each character in the plaintext string.
		for(int i = 0; i < plain_text.length(); i++){
			// Retrieve the map (row) associated with the current plaintext
			Map<Character, Character> row = map.get(plain_text.charAt(i));

			// Check if a valid map (row) exists for the current plaintext character.
			if(row != null){

				// Fetch the cipher character from the row using the character at the current position of the keystream.
				Character value = row.get(keystream.charAt(i));

				 // If a valid cipher character is found, append it to the cipher_text.
				if(value != null){

					cipher_text += value;
				}
			}
		}	
	}

	public String get_keystream() {
		// Get Key string
		return keystream;
	}
	
	public String get_cipher_text() {
		// Return Cipher(plain) text
		return cipher_text;
	}
}
