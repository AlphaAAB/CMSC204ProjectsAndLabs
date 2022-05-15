
public class EmptyQueueException extends Exception {
	/**
	 * Constructor.
	 */
	public EmptyQueueException() {
		this("Empty Queue.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public EmptyQueueException(String message) {
		super(message);
	}
}
