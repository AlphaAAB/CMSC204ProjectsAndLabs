/**
 *
 * @author Alpha Bah
 *
 */

public class NoLowerAlphaException extends Exception {
	/**
	 * Constructor.
	 */
	public NoLowerAlphaException() {
		this("The password must contain at least one lowercase letter.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
