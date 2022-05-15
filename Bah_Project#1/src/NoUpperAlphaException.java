/**
 * 
 * @author Alpha Bah
 *
 */
public class NoUpperAlphaException extends Exception {
	/**
	 * Constructor.
	 */
	public NoUpperAlphaException() {
		this("The password must contain at least one Uppercase letter");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
