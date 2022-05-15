/**
 * 
 * @author Alpha Bah
 *
 */
public class NoSpecialCharacterException extends Exception {
	/**
	 * Constructor.
	 */
	public NoSpecialCharacterException() {
		this("The password must contain a Special Character.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
