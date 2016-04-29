package achala.communication;

import java.rmi.RemoteException;
import java.util.Date;

import achala.communication.utilisateur._Utilisateur;

public class Message extends RemotableObject {

	private static final long serialVersionUID = -2287686573955510539L;

	private String message;

	public Message(_Utilisateur sender, String message) throws RemoteException {
		super(sender, new Date());
		this.setMessage(message);
		this.setWait(true);
	}

	/**
	 * Retroune le message
	 * 
	 * @return String : message retourne
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Affecte le message
	 * 
	 * @param message
	 *            String : message a trasmettre
	 */
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Object getObject() {
		return this.getMessage();
	}

}
