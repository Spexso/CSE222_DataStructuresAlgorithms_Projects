public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
	
	// Constructor
	public preprocessor(String str) {

		initial_string = str;
		preprocessed_string = "";
	}

	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	
	private void capitalize() {
		// Transform String to All Upper Case
		preprocessed_string = initial_string.toUpperCase();
	}

	private void clean() {
		// Transform String to only letters 
		preprocessed_string = preprocessed_string.replaceAll("[^a-zA-Z]", "");
        //System.out.println("Non letter version=> " + preprocessed_string);
	}
	
	public String get_preprocessed_string() {

		return preprocessed_string;
	}
}