package achala.modules.publication.exception;

public class PublicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PublicationException() {
	}

	public PublicationException(String arg0) {
		super(arg0);	}

	public PublicationException(Throwable arg0) {
		super(arg0);
	}

	public PublicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PublicationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
