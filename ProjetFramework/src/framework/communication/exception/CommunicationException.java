package framework.communication.exception;

public class CommunicationException extends Exception {

	private static final long serialVersionUID = -7579178056698687365L;
	
	public CommunicationException(){ super(); }
	
	public CommunicationException(String message) { super(message); }

}
