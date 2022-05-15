/**
 * 
 * @author Alpha Bah
 *
 */
public class WeakPasswordException extends Exception {
	/**
	 * Constructor.
	 */
	public WeakPasswordException() {
		this("The password is a weak password.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public WeakPasswordException(String message) {
		super(message);
	}

}
