package exceptions;

public class RunTimeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3928177661254079553L;

	public RunTimeException() {
    }

    public RunTimeException(String errorMsg) {
        super(errorMsg);
    }

    public RunTimeException(Throwable errorMsg) {
        super(errorMsg);
    }
}

