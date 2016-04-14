package framework.Communication;

import java.rmi.RemoteException;
import java.util.Date;

import framework.Communication.Utilisateur._Utilisateur;

public class Message extends RemotableObject {

	private static final long serialVersionUID = -2287686573955510539L;

	private String message;
	
	public Message(_Utilisateur sender, String message) throws RemoteException {
		super(sender, new Date());
		this.setMessage(message);
		this.setWait(true);
	}
	
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
	}
	
	public Object getObject() {
		return this.getMessage();
	}

	

}
