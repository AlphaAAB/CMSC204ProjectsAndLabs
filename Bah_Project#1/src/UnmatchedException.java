/**
 * 
 * @author Alpha Bah
 *
 */
public class UnmatchedException extends Exception {
	/**
	 * Constructor.
	 */
	public UnmatchedException() {
		this("The two passwords are not the same.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}
