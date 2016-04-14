package framework.Communication;

import java.rmi.RemoteException;
import java.util.Date;

public class Message extends RemotableObject {

	private static final long serialVersionUID = -2287686573955510539L;

	private String message;
	
	public Message(Utilisateur sender, String message) throws RemoteException {
		super(sender, new Date());
		this.setMessage(message);
		this.setWait(false);
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	

}
