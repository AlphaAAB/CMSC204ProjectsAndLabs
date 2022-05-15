import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author alpha bah
 *
 */
public class MorseCodeConverter extends Object {

	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	static String convertToEnglish(File codeFile) throws FileNotFoundException {
		StringBuilder MorseCodeFromFile = new StringBuilder();
		try {
			Scanner scan = new Scanner(codeFile);
			
			while (scan.hasNextLine()) {
				MorseCodeFromFile.append(scan.nextLine());
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return convertToEnglish(MorseCodeFromFile.toString());
		
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code- the morse code
	 * @return the English translation
	 */
	static String convertToEnglish(String code) {
	
		if(code.length()==0) {
			throw new RuntimeException("Enter Morse code to be translated.");
		}
		
		for(int i=0; i<code.length(); i++) {
			//Morse code doesn't have letter or digit
			if(Character.isJavaLetterOrDigit(code.charAt(i)))
				throw new RuntimeException("Morse code doesn't take letter or digit");
		}
		
		String[] letters;
	    String[] words = code.split(" / ");
	    StringBuilder englishTranslation = new StringBuilder();
	   
	    for (String ch : words) {
	      letters = ch.split(" ");
	      for (String temp : letters) {
	        englishTranslation.append(tree.fetch(temp));
	      }
	      englishTranslation.append(" ");
	    }
	    return englishTranslation.toString().trim();
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return the data in the tree in LNR order separated by a space.
	 */
	static String printTree() {
		ArrayList<String> TreeArray = tree.toArrayList();
	    StringBuilder strBuilder = new StringBuilder();

	    for (String letters : TreeArray) {
	    	if(letters !=null)
    		strBuilder.append(letters).append(" ");
	    }
	    return strBuilder.toString().trim();
  }
	
}
