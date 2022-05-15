/**
 * 
 * @author alpha bah
 *
 */
public class InvalidSequenceException extends Exception {
	/**
	 * Constructor.
	 */
	public InvalidSequenceException() {
		this("The password must not have more than 2 of the same character in sequence.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}
